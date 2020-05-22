public interface MailSenderFactory {
    JavaMailSender getSender(String email, String password);
}

@Component
public static class MailSenderFactoryImpl implements MailSenderFactory {

    private final JavaMailerDTO javaMailer;

    @Autowired
    public MailSenderFactoryImpl(JavaMailerDTO javaMailer) {
        this.javaMailer = javaMailer;
    }

    @Override
    public JavaMailSender getSender(final String email, final String password) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setJavaMailProperties(mailProperties(javaMailer));

        mailSender.setHost(javaMailer.getHost());
        mailSender.setUsername(email);
        mailSender.setPassword(password);
        mailSender.setPort(Integer.parseInt(javaMailer.getPort()));
        return mailSender;
    }

    private Properties mailProperties(JavaMailerDTO javaMailer) {
        Properties properties = new Properties();
        properties.put(ApplicationConstant.MAIL_AUTH, ApplicationConstant.TRUE);
        // .....
        properties.put(ApplicationConstant.MAIL_SMTPPORT, javaMailer.getPort());
        return properties;
    }
}