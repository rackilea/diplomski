import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


class SampleMail
{
    public static void main(String args[]) throws Exception
    {
        new Email("yourEmail(sendTheMessage)", "yourEmailPassword", "yourEmail(recvTheMessage)", "subject", "message"); // Send a message

        String[] attachments = {"/home/user/Documents/text.odt"};
        new Email("yourEmail(sendTheMessage)", "yourEmailPassword", "yourEmail(recvTheMessage)", "subject", "message", attachments); // send a message with attachments
    }
}

class Email
{
    private String host, port = "587";

    Email(String mailFrom, String password, String mailTo, String subject, String message) throws Exception
    {
        if (mailFrom.contains("@gmail"))
            this.host = "smtp.gmail.com";
        else if (mailFrom.contains("@yahoo"))
            this.host = "smtp.mail.yahoo.com";
        else
            this.host = "smtp.live.com";

        sendEmail(host, port, mailFrom, password, mailTo, subject, message, null);
    }

    Email(String mailFrom, String password, String mailTo, String subject, String message, String[] attachFiles) throws Exception
    {
        if (mailFrom.contains("@gmail"))
            this.host = "smtp.gmail.com";
        else if (mailFrom.contains("@yahoo"))
            this.host = "smtp.mail.yahoo.com";
        else
            this.host = "smtp.live.com";

        sendEmail(host, port, mailFrom, password, mailTo, subject, message, attachFiles);
    }

    private void sendEmail(String host, String port, final String userName, final String password, String toAddress, String subject, String message, String[] attachFiles) throws Exception
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        Authenticator auth = new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        if (attachFiles != null && attachFiles.length > 0)
        {
            for (String filePath : attachFiles)
            {
                MimeBodyPart attachPart = new MimeBodyPart();

                try
                {
                    attachPart.attachFile(filePath);
                }
                finally
                {
                    multipart.addBodyPart(attachPart);
                }
            }
        }
        msg.setContent(multipart);

        Transport.send(msg);
    }
}