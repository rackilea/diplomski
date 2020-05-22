@Service
public class ThymeEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendMailWithInline() throws MessagingException {

        final Context ctx = new Context();

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject("Sample Email Subject");
        message.setFrom("senderEmail@yahoo.com");
        message.setTo("recipientEmail@yahoo.com");

        final String htmlContent = this.templateEngine.process("emailTemplate.html", ctx);
        message.setText(htmlContent, true);

        String[] attachments = {"C:\\Users\\MyPc\\Dropbox\\CV\\myPDFAttachment.pdf"};

        for (String attachment : attachments) {
            FileSystemResource file = new FileSystemResource(attachment);
            message.addAttachment(file.getFilename(), file);
        }

        this.mailSender.send(mimeMessage);
    }
}