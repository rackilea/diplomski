import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import org.joda.time.DateTime;

import java.io.IOException;

@JsonDeserialize(using = DataDeserializer.class)
public class Data
    implements JsonSerializable
{
    public DateTime dateTime;
    public Double temperature;

    public Data(DateTime dateTime, Double temperature){
        this.dateTime = dateTime;
        this.temperature = temperature;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public long getDateTimeAsUnixTimestamp() {
        return dateTime.getMillis();
    }
    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }


    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void serialize(final JsonGenerator jgen,
        final SerializerProvider provider)
        throws IOException, JsonProcessingException
    {
        jgen.writeStartArray();
        jgen.writeNumber(temperature);
        jgen.writeNumber(dateTime.getMillis());
        jgen.writeEndArray();
    }

    @Override
    public void serializeWithType(final JsonGenerator jgen,
        final SerializerProvider provider, final TypeSerializer typeSer)
        throws IOException, JsonProcessingException
    {
        typeSer.writeTypePrefixForArray(this, jgen);
        serialize(jgen, provider);
        typeSer.writeTypeSuffixForArray(this, jgen);
    }
}