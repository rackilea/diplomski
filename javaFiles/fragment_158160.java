@Prototype
public class ObjectInstance {

    @Inject
    private ObjectStorage objectStorage;

    private String name;
    private String spec;
    private Long id;


    public ObjectInstance() {}

    public ObjectInstance(String name, String spec, Long id) {
        this.name = name;
        this.spec = spec;
        this.id = id;
    }

}