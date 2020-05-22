@Path("spring-hello")
public class JerseySpringResource {

    @Autowired
    private GreetingService greetingService;

    @Inject
    private DateTimeService timeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return String.format("%s: %s", timeService.getDateTime(), greetingService.greet("World"));
    }
}