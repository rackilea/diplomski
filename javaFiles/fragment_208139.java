import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

;

public class JacksonTest {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, true);

        Pojo pojo = new Pojo();
        pojo.userStatus = UserStatus.Activated;
        String json = mapper.writeValueAsString(pojo);
        System.out.println(json);
        Pojo deserializedPojo = mapper.readValue(json, Pojo.class);
        System.out.println("--");
        System.out.println(deserializedPojo);
    }

    public static class Pojo {
        public UserStatus userStatus;

        @Override
        public String toString() {
            return userStatus.name();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public enum UserStatus {
        Unregistered, Activated, Deactivated, Locked;

        @JsonValue
        public String toValue() {
            return name();
        }
    }
}