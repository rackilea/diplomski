import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Jackson2 {


    public static void main(String[] args) throws Exception {

        final ObjectMapper mapper = new ObjectMapper();
        final String jsonInString = "{\"name\":\"hello world\",\"something\":\"from string\"}";
        System.out.println(jsonInString);

        Foo newFoo = mapper.readValue(jsonInString, Foo.class);
        System.out.println(newFoo.getName());
        System.out.println(newFoo.getSomething());
    }
}

class Foo {

    @JsonProperty
    private String name;
    private String something;

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    Foo() {
    }

  // @JsonCreator
    public Foo(final Map<String, Object> properties) {
            System.out.println("printing.."+properties);
            something =  "Something from constructor";
     }
    @JsonCreator
    public Foo(@JsonProperty("something") String something ) {
            System.out.println("printing.."+name);
            this.something =  "Something from constructor appended"+something;
    }



}