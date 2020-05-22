@Service
public static class MailService {
    private final MailSenderFactory mailSenderFactory;

    public MailService(MailSenderFactory mailSenderFactory) {
        this.mailSenderFactory = mailSenderFactory;
    }

    public void sendMail() {
        JavaMailSender mailSender = mailSenderFactory.getSender("john.smith@gmail.com", "123456");
        mailSender.send(...);
    }
}