@Entity
@Data
public class A {

    @JsonProperty
    private String value;

    @JsonGetter("value")
    public HashMap getValueAsJson(){
        return new Gson().fromJson(value, HashMap.class);
    }
}