@Configuration
public class Validator {
    @Autowired
    private ApplicationContext applicationContext;
    private Resource validationResource;


    @PostConstruct
    public void init(){
        validationResource = applicationContext.getResource("classpath*:validation.xml");
    }