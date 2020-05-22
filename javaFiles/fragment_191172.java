@Service
public class MailService {

    @Value("${mailFrom}")
    private String mailFrom;

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }
}