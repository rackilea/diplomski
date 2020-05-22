@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String username;

    public void enviarRelatorio(String nome, String email, String obra,long medicao, Locale locale) throws MessagingException {

        String subject = "Novo relatório";

        final Context ctx = new Context(locale);
        ctx.setVariable("nome", nome);
        ctx.setVariable("obra", obra);
        ctx.setVariable("data", DataUtils.getInstance().getDataString(medicao));
        ctx.setVariable("logo", "logo.jpg");

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true, "UTF-8");
        message.setSubject(subject);
        message.setTo(email);

        try {
            message.setFrom(new InternetAddress(username, "Sistema"));
        } catch (UnsupportedEncodingException e) {
        }

        final String htmlContent = this.templateEngine.process( "email-relatorio", ctx);
        message.setText(htmlContent, true);

        try {
            message.addInline("logo.jpg", new FileSystemResource("imgs/logo-pro.jpg"), "image/jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.mailSender.send(mimeMessage);
    }
}