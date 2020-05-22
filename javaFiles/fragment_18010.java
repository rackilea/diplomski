@Component("RestAuthFilter")
public class RestAuthFilter implements Filter {

  private final List<String> restClientIps;

  @Autowired
  public RestAuthFilter(Environment env) {
    String restClientIpsProperty = env.getRequiredProperty("whitelist.rest.ips");
    restClientIps = // parse/split from restClientIpsProperty
  }
  ...
}