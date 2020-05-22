@Component
public class SomeService {
   @Autowired
   RestTemplate restTemplate;

   public String doSomething() {
     try {
       restTemplate.postForEntity("http://my-service/some/url", 
                                  new BazzleRequest(...), 
                                  Void.class);
       return "so bazzle my eyes dazzle";
     } catch(HttpStatusCodeException e) {
       return "Not bazzle today!";
     }
   }
}