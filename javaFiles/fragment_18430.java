import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Main {
    public static void main(String[] args) throws Exception {
        ResponseEntity<Object> entity = ResponseEntity
                .ok()
                .header("header", "value")
                .body("Everything is OK!");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(ResponseEntity.class, ResponseEntityMixin.class);
        objectMapper.addMixIn(HttpStatus.class, HttpStatusMixIn.class);

        String json = objectMapper.writeValueAsString(entity);
        TypeReference ref = new TypeReference<ResponseEntity<Object>>() {
        };
        ResponseEntity<Object> result = objectMapper.readValue(json, ref);
        System.out.println(result);
        System.out.println(result.equals(entity));
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ResponseEntityMixin {
    @JsonCreator
    public ResponseEntityMixin(@JsonProperty("body") Object body,
                               @JsonDeserialize(as = LinkedMultiValueMap.class) @JsonProperty("headers") MultiValueMap<String, String> headers,
                               @JsonProperty("statusCodeValue") HttpStatus status) {
    }
}

class HttpStatusMixIn {

    @JsonCreator
    public static HttpStatus resolve(int statusCode) {
        return HttpStatus.NO_CONTENT;
    }
}