import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;

public final class DataDeserializer
    extends StdDeserializer<Data>
{
    public DataDeserializer(final Class<?> vc)
    {
        super(vc);
    }

    public DataDeserializer(final JavaType valueType)
    {
        super(valueType);
    }

    @Override
    public Data deserialize(final JsonParser jp,
        final DeserializationContext ctxt)
        throws IOException, JsonProcessingException
    {
        final JsonNode node = jp.readValueAsTree();
        if (!node.isArray() || node.size() != 2)
            throw new JsonMappingException("was expecting array of two elements");

        final double temperature;
        DateTime dateTime;

        JsonNode element;
        element = node.get(0);
        if (!element.isFloatingPointNumber())
            throw new JsonMappingException("was expecting a double");

        temperature = element.doubleValue();

        element = node.get(1);
        if (!(element.isIntegralNumber() && element.canConvertToLong()))
            throw new JsonMappingException("was expecting a long");

        dateTime = new DateTime(element.longValue());
        return new Data(dateTime, temperature);
    }
}