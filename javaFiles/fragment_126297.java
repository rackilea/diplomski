import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("Puppy", Boolean.TRUE);
        map.put("Apple", 2);
        map.put("Jet", "Li");
        Examples examples = new Examples();
        examples.setOverlyComplicated("yes");
        examples.setMap(map);

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.putPOJO("Examples", examples);
        ObjectNode currentNode = rootNode.putObject("Single");
        currentNode.put("One", 1);

        mapper.writeValue(System.out, rootNode);
    }
}

class Examples implements JsonSerializable {

    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ToXmlGenerator toXmlGenerator = (ToXmlGenerator) gen;
        toXmlGenerator.writeStartObject();

        writeAttributes(toXmlGenerator);
        writeMap(toXmlGenerator);

        toXmlGenerator.writeEndObject();
    }

    private void writeAttributes(ToXmlGenerator gen) throws IOException {
        if (overlyComplicated != null) {
            gen.setNextIsAttribute(true);
            gen.writeFieldName("overlyComplicated");
            gen.writeString(overlyComplicated);
            gen.setNextIsAttribute(false);
        }
    }

    private void writeMap(ToXmlGenerator toXmlGenerator) throws IOException {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            toXmlGenerator.writeObjectField(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(gen, serializers);
    }

    private String overlyComplicated;
    private Map<String, Object> map;

    // getters, setters, toString
}