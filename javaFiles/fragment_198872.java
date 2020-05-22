public class MyService {

    @Inject // or @Autowired (both work)
    private MyRepository repository;

    @Context
    private HttpServletRequest request;

}