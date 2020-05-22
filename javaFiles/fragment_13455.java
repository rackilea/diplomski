@Service
@Profile("!mail") // By adding the exclamination mark, this implementation will be used when the mail profile isn't active
public class NoopMailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String subject, String text, String... emails) {
        logger.debug("Dummy implementation, no e-mail is being sent");
    }
}