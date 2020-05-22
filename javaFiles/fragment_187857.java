import javax.persistence.Embeddalbe;
import javax.persistence.Column;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "address", "country_code", "currency_code", "email_address", "name", "phone" })
@Embeddable
public class UserInformation {

    @JsonProperty("country_code")
    @NotNull
    @Column(name = "COUNTRY_CODE")
    private String countryCode;