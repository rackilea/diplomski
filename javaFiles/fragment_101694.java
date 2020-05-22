public class MyApplication {

    private EmailService email;

    public void setEmailService(EmailService emailService) {
        this.email = emailService;
    }

    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}