@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }
}

@Component
public class UpdateTask {
    @Autowired 
    ThresholdInfoRepository thresholdInfoRepository;

    @Scheduled(fixedRate = ...)
    public void updateSensor() {
        thresholdInfoRepository.find(...)
        readoutRepository.save(...);
    }
}