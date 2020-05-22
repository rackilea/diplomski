@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqBody {
    @NotNull
    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;
    //other fields

    @JsonProperty(value = "create_anonymous_account")
    private Boolean createAnonymousAccount ;
}