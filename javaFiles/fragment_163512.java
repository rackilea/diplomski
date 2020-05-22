@Singleton
public class EmailService implements MessageService {

    private FancyEmailService fancyEmailService;

    @Inject
    public EmailService(FancyEmailService fes){
       fancyEmailService = fes;
    }

    public boolean sendMessage(String msg, String receipient) {
        //some fancy code to send email
        System.out.println("Email Message sent to "+receipient+" with message="+msg);
        fancyEmailService.doSomething();
        return true;
    }
}