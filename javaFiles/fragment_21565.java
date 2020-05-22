import javax.mail.*;
  import javax.mail.internet.*;

  import java.util.Properties;

  public class Email {

     public static void sendMessage(String emailaddress, String subject, String body) {
        try {
           Properties props = new Properties();
           props.setProperty("mail.transport.protocol", "smtp");
           props.setProperty("mail.host", "myhost");

           Session mailSession = Session.getDefaultInstance(props, null);
           Transport transport = mailSession.getTransport();

           MimeMessage message = new MimeMessage(mailSession);
           message.setSubject("Testing javamail plain");
           message.setContent("This is a test", "text/plain");
           message.addRecipient(Message.RecipientType.TO, new InternetAddress("test@example.com"));

           transport.connect();
           transport.sendMessage(message,
                   message.getRecipients(Message.RecipientType.TO));
           transport.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
     }
  }