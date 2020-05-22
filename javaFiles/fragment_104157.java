public class CaptchaFilter extends UsernamePasswordAuthenticationFilter {

@Autowired
private RestTemplate restTemplate;
private static final String POST = "POST";
private static final Logger LOG = Logger.getLogger(UsernamePasswordAuthenticationFilter.class);

@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
  ...
} 

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest request = (HttpServletRequest) req;
    final HttpServletResponse response = (HttpServletResponse) res;
    if(request.getRequestURI().indexOf("login") != -1 && request.getMethod().equals(POST) && 
       LoginAttemptsSingleton.getInstance().getLoginAttepmts().containsKey(ipAddress) &&
       LoginAttemptsSingleton.getInstance().getLoginAttepmts().get(ipAddress) > 3){
        //Captcha validation here
    }else{
        //No captcha validation, so keep going throug next filter in chain
        chain.doFilter(request, response);
    }
  }
 }