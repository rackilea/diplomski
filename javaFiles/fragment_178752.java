@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;
    public String greet(String userid) {
       return greetingRepository.greet(userid); 
    }
}

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", greetingService.greet(name));
    }
    @RequestMapping("/greeting2")
    public String greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
      GreetingService newGreetingService = new GreetingService();
      return String.format("Hello %s", newGreetingService.greet(name));
    }
}