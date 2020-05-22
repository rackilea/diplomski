@Aspect
@Component
public class LogUsernameAop {
    Logger logger = LoggerFactory.getLogger(LogUsernameAop.class);
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Before("@annotation(LogUsername)")
    public void logUsername() throws Throwable {
        logger.info(authenticationFacade.getAuthentication().getName());
        LoggedUser.logIn(authenticationFacade.getAuthentication().getName());
    }
}