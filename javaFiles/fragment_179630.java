import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        String json1 = "json 1 ...";
        String json2 = "json 2....";

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(json1, Pojo.class));
        System.out.println(mapper.readValue(json2, Pojo.class));
    }
}