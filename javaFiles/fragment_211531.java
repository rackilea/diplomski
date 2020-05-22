@Configuration
public class MyProperties{

    @Value("{my.property}")
    public String  myProperty;
}