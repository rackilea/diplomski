@Component
@DependsOn("myAspect")
public class ServiceInitialiserFacsimile {

    private final SampleService sampleService;

    @Autowired
    public ServiceInitialiserFacsimile(SampleService ss) {
        this.sampleService = ss;
    }

    @PostConstruct
    public void initialiseAllTheServices() {
        this.sampleService.init();
    }

}