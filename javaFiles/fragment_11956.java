@Configuration
@PropertySource(value="classpath:anyname.properties")
public class PropConfig{

//you can inject property values anywhere in the code that is under spring context(e.g. @Service, @Repository, @Component etc)
@Value("${user.login}")
private String login;

public String getUserLogin(){
    return login;
}
}