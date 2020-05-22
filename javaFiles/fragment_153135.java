import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonProgram {

    public static void main(String[] args) throws Exception {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Error.class, new ErrorJsonSerializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        System.out.println(mapper.writeValueAsString(Error.NOT_FOUND));
    }
}