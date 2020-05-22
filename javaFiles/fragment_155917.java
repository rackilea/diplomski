@ImplementedBy(EmailServiceImpl.class)
public interface EmailService {
    void sendEmail(AppUser appUser, String mailString, String subject);
}

@Singleton
public class EmailServiceImpl implements EmailService {
    private final Configuration config;

    @Inject
    public EmailServiceImpl(Configuration config) {
        this.config = config;
    }

    public void sendEmail(AppUser appUser, String mailString, String subject) {
        final Properties props = new Properties(); 
        final String auth = config.getString("mail.smtp.auth‌​")
        final String starttls = config.getString("mail.smtp.star‌​ttls.enable");
    }
}