import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User {

    @JacksonXmlProperty
    private String login;

    @JacksonXmlProperty
    @JsonSerialize(using=your.class.package.PasswordSerializer.class)
    @JsonDeserialize(using=your.class.package.PasswordDeserializer.class)
    private String password;
    // ... 
}