@Configuration
public class MyConfig {

    @Value("#{'${com.mycompany.propertygroup.propertyname:${oldconvention.propertyname:}}'}")
    private String myValue;
}