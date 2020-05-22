import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File json = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();

        FieldDefinitions fields = mapper.readValue(json, FieldDefinitions.class);
        System.out.println("Required");
        fields.getFields().getRequired().forEach(r ->
                System.out.println(r + " = " + fields.getDescriptions().get(r)));
        System.out.println("Optional");
        fields.getFields().getOptional().forEach(r ->
                System.out.println(r + " = " + fields.getDescriptions().get(r)));
    }
}