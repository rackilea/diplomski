@RestController
@RequestMapping("/u/util/")
public class HealthCheckAdapter {
    private HealthDbService healthCheck;

    @Autowired // not even needed in recent versions
    public HealthCheckAdapter(HealthDbService healthCheck) {
        this.healthCheck = healthCheck;
    }
}