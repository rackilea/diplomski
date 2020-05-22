public class FancyEmailService {

    private final int i;

    public FancyEmailService(int i){
        this.i = i;
    }

    public void doSomething(){
        System.out.println("i is injected with " + i);
    }

}

@Singleton
public class EmailService implements MessageService {

    private FancyEmailService fancyEmailService;

    @Inject
    public EmailService(@Named("fancy") int someValue){
       fancyEmailService = new FancyEmailService(someValue);
    }

    public boolean sendMessage(String msg, String receipient) {
        //some fancy code to send email
        System.out.println("Email Message sent to "+receipient+" with message="+msg);
        fancyEmailService.doSomething();
        return true;
    }
}