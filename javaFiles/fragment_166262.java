@Component
public class HystrixDemoService {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @HystrixCommand(fallbackMethod = "getFallbackCustomerName")
    public String getCustomerName() {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancer.choose("eureka-client-2");
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri, String.class);
    }

    public String getFallbackCustomerName() {
        System.out.println("coming inside fallback method");
        return "Resillient Customer";
    }
}