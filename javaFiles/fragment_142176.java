@Component
public class MyProperty {

    @Value("${my.property}")
    private String myProperty;

    ...
}