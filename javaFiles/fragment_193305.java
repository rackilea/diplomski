import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {

    @JsonProperty("field1")
    public String fieldOne;

    @JsonIgnore
    public String field2; // this field will be ignored

    @Override
    public String toString() {
        return "field1: " + fieldOne + ", field2: " + field2;
    }
}