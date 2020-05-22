import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SampleMail 
{
     public static void main(String [] args) throws Exception
     {  
          final String from = "siddhesh.kalgaonkar@ves.ac.in"; // change accordingly
          final String password = "yourPassword"; // change accordingly
          String to = "kalgaonkarsiddhesh@gmail.com"; // change accordingly
          String host = "localhost"; // or IP address

          // Get system properties
          Properties properties = System.getProperties();

          // Setup mail server
          properties.put("mail.smtp.host", host);
          properties.put("mail.smtp.port", 587);
          properties.put("mail.smtp.auth", "true");
          properties.put("mail.smtp.starttls.enable", "true");
          properties.put("mail.user", from);
          properties.put("mail.password", password);

          // Get the default Session object.
          Authenticator auth = new Authenticator()
          {
              public PasswordAuthentication getPasswordAuthentication()
              {
                  return new PasswordAuthentication(from, password);
              }
          };
          Session session = Session.getInstance(properties, auth);

          try
          {
             // Create a default MimeMessage object.
             MimeMessage message = new MimeMessage(session);

             // Set From: header field of the header.
             message.setFrom(new InternetAddress(from));

             // Set To: header field of the header.
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

             // Set Subject: header field
             message.setSubject("This is the Subject Line!");

             // Now set the actual message
             message.setText("This is actual message");

             // Send message
             Transport.send(message);
             System.out.println("Sent message successfully....");
          }
          catch (SendFailedException mex)
          {
             mex.printStackTrace();
          }
     }
}