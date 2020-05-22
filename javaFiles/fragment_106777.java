@Component
public class SmtpAuthenticator extends Authenticator {
    private static final Logger LOG = 
    LogManager.getLogger(SmtpAuthenticator.class.getSimpleName());

    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @PostConstruct
    public void init() {
        LOG.info(SmtpAuthenticator.class.getSimpleName() + " started...");
        LOG.debug("username=" + username);
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            LOG.debug("Username and password are correct...");
            return new PasswordAuthentication(username, password);
        }
    LOG.error("Not correct mail login data!");
    return null;
    }
}