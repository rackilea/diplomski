import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class EMail {

    public enum SendMethod{
        HTTP, TLS, SSL
    }

    private static final String EMAIL_PATTERN = 
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isValidEmail(String address){
        return (address!=null && address.matches(EMAIL_PATTERN));
    }

    public static String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "localhost";
        }
    }

    public static boolean sendEmail(final String recipients, final String from,
            final String subject, final String contents,final String[] attachments,
            final String smtpserver, final String username, final String password, final SendMethod method) {

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", smtpserver);

        Session session = null;

        switch (method){
        case HTTP:
            if (username!=null) props.setProperty("mail.user", username);
            if (password!=null) props.setProperty("mail.password", password);
            session = Session.getDefaultInstance(props);
            break;
        case TLS:
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "587");
            session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(username, password);
                }
            });
            break;
        case SSL:
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(username, password);
                }
            });
            break;
        }

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(from);
            message.addRecipients(Message.RecipientType.TO, recipients);
            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();

            BodyPart bodypart = new MimeBodyPart();
            bodypart.setContent(contents, "text/html");

            multipart.addBodyPart(bodypart);

            if (attachments!=null){
                for (int co=0; co<attachments.length; co++){
                    bodypart = new MimeBodyPart();
                    File file = new File(attachments[co]);
                    DataSource datasource = new FileDataSource(file);
                    bodypart.setDataHandler(new DataHandler(datasource));
                    bodypart.setFileName(file.getName());
                    multipart.addBodyPart(bodypart);
                }
            }

            message.setContent(multipart);
            Transport.send(message);

        } catch(MessagingException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}