@Service
public class Dependency {

    private String xyz;
    private String abc;

    @Autowired
    public Dependency(@Value("${xyz.value}") String xyz, @Value("${abc.value}") String abc) {
        this.xyz = xyz;
        this.abc = abc;
    }
}