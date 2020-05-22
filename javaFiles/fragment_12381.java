package gmail.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.PasswordAuthentication;


public class GmailEmail {

    final String userName ="pan54321@gmail.com";
    final String password="tqw12";

    public static void main(String[] args) {
        new GmailEmail();
    }

    public GmailEmail(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true") ;
        properties.put("mail.smtp.auth", "true") ;

        Session session = Session.getInstance(properties,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(userName, password);
            }

        });

        try{
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("pan54321@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                                  InternetAddress.parse("vi@gmail.com"));
            message.setSubject("my First Email");
            message.setContent("<h:body>You wrote first email</body>","text/html;     charset=utf-8");
            Transport.send(message);
        }catch(MessagingException
               messageException){
            throw new RuntimeException(messageException);
        }

    }

}