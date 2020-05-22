import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.math.BigDecimal;

public class JsonApp {

    public static void main(String[] args) {
        Parameter parameter = new Parameter();
        parameter.setPrevValue(new BigDecimal("3.9E38"));

        SimpleModule module = new SimpleModule();
        module.addDeserializer(JsonNode.class, new BigDecimalFirstJsonNodeDeserializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        JsonNode node = mapper.convertValue(parameter, JsonNode.class);
        System.out.println(node);
    }
}

class BigDecimalFirstJsonNodeDeserializer extends JsonNodeDeserializer {

    @Override
    public JsonNode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return super.deserialize(new BigDecimalJsonParser(p), ctxt);
    }
}

class BigDecimalJsonParser extends JsonParserDelegate {

    public BigDecimalJsonParser(JsonParser parser) {
        super(parser);
    }

    @Override
    public NumberType getNumberType() {
        return NumberType.BIG_DECIMAL;
    }

    @Override
    public BigDecimal getDecimalValue() throws IOException {
        String value = getText();
        return new BigDecimal(value);
    }
}

class BigDecimalPlainStringJsonSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(o.toPlainString());
    }
}

class Parameter {

    @JsonSerialize(using = BigDecimalPlainStringJsonSerializer.class)
    private BigDecimal prevValue;

    public void setPrevValue(BigDecimal prevValue) {
        this.prevValue = prevValue;
    }


    public BigDecimal getPrevValue() {
        return prevValue;
    }
}