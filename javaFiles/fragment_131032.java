import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<String> jsons = new ArrayList<>();
        jsons.add("{}");
        jsons.add("true");
        jsons.add("{\"id\":1}");

        RawJsons root = new RawJsons();
        root.setJsons(jsons);
        System.out.println(mapper.writeValueAsString(root));
    }
}

@JsonSerialize(using = RawJsonSerializer.class)
class RawJsons {

    private List<String> jsons;

    public List<String> getJsons() {
        return jsons;
    }

    public void setJsons(List<String> jsons) {
        this.jsons = jsons;
    }
}

class RawJsonSerializer extends JsonSerializer<RawJsons> {

    @Override
    public void serialize(RawJsons value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        if (value != null && value.getJsons() != null) {
            for (String json : value.getJsons()) {
                gen.writeRawValue(json);
            }
        }
        gen.writeEndArray();
    }
}