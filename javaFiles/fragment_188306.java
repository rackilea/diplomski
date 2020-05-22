@Service
public class SampleService {

    @Autowired
    private FreeMarkerService freeMarkerService;

    public String callProcess() {
        return freeMarkerService.process();
    }
}