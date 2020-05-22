import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
     public static int Send(String SMTPServer,
                        String Sender,
                        String Recipient,
                        String Subject,
                        String Body,
                        String ErrorMessage,
                        String Attachments) {
    // Error status;
    int ErrorStatus = 0;

    // Create some properties and get the default Session;
    final String username = Sender;
    final String password = "pswd";

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
       // Create a message.
       MimeMessage msg = new MimeMessage(session);

       // extracts the senders and adds them to the message.
       // Sender is a comma-separated list of e-mail addresses as per RFC822.
       {
          InternetAddress[] TheAddresses = InternetAddress.parse(Sender);
          msg.addFrom(TheAddresses);
       }

       // Extract the recipients and assign them to the message.
       // Recipient is a comma-separated list of e-mail addresses as per RFC822.
       {
          InternetAddress[] TheAddresses = InternetAddress.parse(Recipient);
          msg.addRecipients(Message.RecipientType.TO,TheAddresses);
       }

       // Subject field
       msg.setSubject(Subject);

       // Create the Multipart to be added the parts to
       Multipart mp = new MimeMultipart();

       // Create and fill the first message part
       {
          MimeBodyPart mbp = new MimeBodyPart();
          mbp.setText(Body);

          // Attach the part to the multipart;
          mp.addBodyPart(mbp);
       }

       // Attach the files to the message
       if (null != Attachments) {
          int StartIndex = 0, PosIndex = 0;
          while (-1 != (PosIndex = Attachments.indexOf("///",StartIndex))) {
             // Create and fill other message parts;
             MimeBodyPart mbp = new MimeBodyPart();
             FileDataSource fds =
             new FileDataSource(Attachments.substring(StartIndex,PosIndex));
             mbp.setDataHandler(new DataHandler(fds));
             mbp.setFileName(fds.getName());
             mp.addBodyPart(mbp);
             PosIndex += 3;
             StartIndex = PosIndex;
          }
          // Last, or only, attachment file;
          if (StartIndex < Attachments.length()) {
             MimeBodyPart mbp = new MimeBodyPart();
             FileDataSource fds = new FileDataSource(Attachments.substring(StartIndex));
             mbp.setDataHandler(new DataHandler(fds));
             mbp.setFileName(fds.getName());
             mp.addBodyPart(mbp);
          }
       }

       // Add the Multipart to the message
       msg.setContent(mp);

       // Set the Date: header
       msg.setSentDate(new Date());

       // Send the message;
       Transport.send(msg);
    } catch (MessagingException MsgException) {
        System.out.println("blows here");
        ErrorMessage = MsgException.toString();
        Exception TheException = null;
        if ((TheException = MsgException.getNextException()) != null)
         ErrorMessage += "\n" + TheException.toString();
         ErrorStatus = 1;
    }
    System.out.println(ErrorMessage);
    return ErrorStatus;
 } // End Send method

    public static void main(String args[]){
        SendMail.Send("smtp.gmail.com", "my_mail@gmail.com", "my_mail@gmail.com",
                 "try sending mail", "came? ","" ,null); 
    }


 } // End of public class SendMail