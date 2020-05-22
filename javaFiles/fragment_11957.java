@ConfigurationProperties(prefix = "user")
public class NewProps{
//value of this field will be automatically mapped to "user.login" in "anyName.properties" file
private String login;
 public String getUserLogin(){
    return login;
 }
}