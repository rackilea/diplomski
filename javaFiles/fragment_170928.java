import ...TargetClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import java.io.IOException;

public final class JsonSchemaGenerator {

    private JsonSchemaGenerator() { };

    public static void main(String[] args) throws IOException {
        System.out.println(JsonSchemaGenerator.getJsonSchema(TargetClass.class));
    }

    public static String getJsonSchema(Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        JsonSchema schema = mapper.generateJsonSchema(clazz);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
    }

}