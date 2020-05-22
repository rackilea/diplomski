import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import play.mvc.Controller;
import play.mvc.Result;

public class MailController extends Controller {


  public Result sendEmail() throws EmailException {
HtmlEmail email = new HtmlEmail();
    String authuser = "..........@gmail.com";
    String authpwd = "XXXXXX";
    email.setSmtpPort(587);
    email.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
    email.setDebug(true);
    email.setHostName("smtp.gmail.com");
    email.setFrom("from@gmail.com", "SenderName");
    email.setSubject("TestMail");
    email.setHtmlMsg("<html><body><h1>welcome to u</h1></body></html>");
    email.addTo("to@gmail.com", "receiver name");
    email.setTLS(true);
    email.send();
 return play.mvc.Results.ok("Success");
  }
}