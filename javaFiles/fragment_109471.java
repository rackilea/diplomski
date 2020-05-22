@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , 
visible = true,
property = "credentialType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CardCredentialDto.class, name = "card"),
        @JsonSubTypes.Type(value = MobileCredentialDto.class, name = "mobile"),
})
@Getter
@Setter
public class CredentialDto {
   @JsonProperty(value = "credentialType")
    private CredentialType credentialType;

    @JsonCreator
    public CredentialDto(@JsonProperty("credentialType") final String credentialType) {
        this.credentialType = CredentialType.valueOf(credentialType);
    }

    public CredentialDto() {

    }

      public void setCredentialType(final CredentialType credentialType) {
        this.credentialType = CredentialType.MOBILE;
    }
}