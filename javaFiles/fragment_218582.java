public class MyApplication {
    private final EmailService email;

    public MyApplication(EmailService email) {
        this.email = email;
    }

    public boolean processMessages (String msg , String recipient ) {
        if (msg.length == 0 || recipient.length == 0 ) {
            return false ;
        }
        return this.email.sendEmail (msg , recipient ) ;
    }
}