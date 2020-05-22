import thepackage.from.externaljar.EmailSender;

@Configuration
public class EmailSenderConfiguration {

    @Bean
    public EmailSender emailSender() {
        EmailSender emailSender = new EmailSender();
        emailSender.setConfig1(...);
        emailSender.setConfig2(...);
        //and on...
        return emailSender;
    }
}