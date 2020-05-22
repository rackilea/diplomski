import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./src/main/resources/test.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        Orgnization root = mapper.readValue(jsonFile, Orgnization.class);
        System.out.println(root);
    }
}