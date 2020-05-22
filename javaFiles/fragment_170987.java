@RequestScoped
public class Configuration {

    @Inject
    @ConfigProperty(name = "myProperty")
    private String myProperty;

    @Inject
    @ConfigProperty(name = "myProperty2")
    private String myProperty2;

    ....

}