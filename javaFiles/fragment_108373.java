import java.util.Properties; 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// define the class
class SendMailTLS {

    // define a method which recive your status code
    // instead of define main method
    public void sendMail(String statusCode) {

        final String username = "yourUsername@gmail.com";
        final String password = "yourPassword";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("yourSendFromAddress@domain.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("yourRecipientsAddress@domain.com"));


            message.setSubject("Status alert");

            // THERE YOU CAN USE STATUSCODE FOR EXAMPLE...
            if(statusCode.equals("403")){
                message.setText("Hey there,"
                + "\n\n You recive an 403...");
            }else{
                message.setText("Hey there,"
                + "\n\n There is something wrong with the service. The httpStatus from the last call was: ");
            }           

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

// get status code
def statusCode = context.expand('${#TestCase#httpStatusCode}');
// create new instance of your class
def mailSender = new SendMailTLS();
// send the mail passing the status code
mailSender.sendMail(statusCode);