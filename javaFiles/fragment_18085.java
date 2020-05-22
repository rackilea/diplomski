import com.sendgrid.*;

public class SendGridExample {
  public static void main(String[] args) {
    SendGrid sendgrid = new SendGrid("SENDGRID_APIKEY");

    SendGrid.Email email = new SendGrid.Email();

    email.addTo("test@sendgrid.com");
    email.setFrom("you@youremail.com");
    email.setSubject("Sending with SendGrid is Fun");
    email.setHtml("and easy to do anywhere, even with Java");

    SendGrid.Response response = sendgrid.send(email);
  }
}