@Component
@Path("/helloController")
public class HelloController {

  @Autowired
  @Qualifier("helloService")
  private HelloService helloService ;


   @GET
   @Path("/hello")
   public String hello() {
    helloService.service();
  }
}