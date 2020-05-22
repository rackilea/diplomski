@Component
@Provides
public class MyComponent implements MyService {

    @Property
    private String hidden;

    @ServiceProperty
    private String shown;

    [...]

}