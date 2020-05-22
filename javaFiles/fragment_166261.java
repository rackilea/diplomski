@SpringBootApplication
public class DemoPranayEurekaClient1Application {
    public static void main(String[] args) {
        SpringApplication.run(DemoPranayEurekaClient1Application.class, args);
    }
}

@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
class HystrixDemoApplication {
    @Autowired
    HystrixDemoService hystrixDemoService;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String name() {
        String str = hystrixDemoService.getCustomerName();
        return "I'm A talking to "+str;
    }

}