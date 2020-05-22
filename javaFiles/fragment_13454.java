@Service
@Profile("mail") // Only create this bean when the 'mail' profile is used
public class JavaMailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void send(String subject, String text, String... emails) {
        // MailMessage object configuration
        mailSender.send(mail);
    }
}