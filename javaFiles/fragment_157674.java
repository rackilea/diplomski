import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        Map<Path, String> path2String = new HashMap<>();
        path2String.put(Paths.get("user", "downloads"), "Downloads");
        path2String.put(Paths.get("home", "des"), "Desktop");

        SimpleModule nioModule = new SimpleModule();
        nioModule.addKeyDeserializer(Path.class, new PathKeyDeserializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(nioModule);

        String json = mapper.writeValueAsString(path2String);
        System.out.println(json);

        path2String = mapper.readValue(json, new TypeReference<HashMap<Path, String>>() {});
        System.out.println(path2String);
    }

}