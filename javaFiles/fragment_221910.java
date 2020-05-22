import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.addMixIn(MyClass.class, MyClassMixIn.class);

        System.out.println(mapper.writeValueAsString(new MyClass()));
    }
}

interface MyClassMixIn {

    @JsonProperty
    String getField2();
}