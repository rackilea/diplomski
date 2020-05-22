@Component
public class TestObjectImpl {
    private int id;
    private String value;

    @Autowired
    public TestObjectImpl(@Value("${prop1}")int id, @Value("${prop2}")String value){
        this.id = id;
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public String getValue(){
        return value;
    }
}