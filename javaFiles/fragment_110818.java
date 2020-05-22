@Configuration
public class TestConfig {

    @Bean
    public JavaMailSender mailSender() {
       // example of returning a mock object 
       return Mockito.mock(JavaMailSender.class);
    }    

    @Bean
    public GreenMail smtpServer() {
       // another mock
       return Mockito.mock(GreenMail.class);
    }

    @Bean
    public MailClientService mailClientService(){
        // this could also be used to return a Mock object
        return new MailClientService();
    }
}