@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "name",
        "password"

})
public class Login{
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;

}