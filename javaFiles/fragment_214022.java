@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    public MailServiceImpl (JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void send (String receiver, String sender, String message, String filenameAndLocation) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare (MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setTo(receiver);
                messageHelper.setFrom(sender);
                messageHelper.setSubject("test subject");
                messageHelper.setText(message);
            }
        };
        this.javaMailSender.send(preparator);
    }
}