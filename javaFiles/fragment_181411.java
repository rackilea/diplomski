import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;
public class MailerService {
  MailerClient mailerClient;

  public MailerService(MailerClient mailerClient){
    this.mailerClient = mailerClient;
  }

  public void sendEmail() {
    Email email = new Email();
    email.setSubject("Activation Link");
    email.setFrom("from@gmail.com");
    email.addTo("to@gmail.com");
    email.setBodyText("hello");
    mailerClient.send(email);
  }
}