@Component
@Aspect
public class Logs {
   @Autowired(required = false)
   private HttpServletRequest request;
...