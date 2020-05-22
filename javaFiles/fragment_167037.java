/**
 GmailSmtpSSL emailNotify = new GmailSmtpSSL(cred[ID], cred[PASS]);

 emailNotify.sendMailTo("self","Testing AlfaDX Gmail module", "Yes it works");

**/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSmtpSSL {

    GmailSmtpSSL(String username,String password) {
        usern = username;
        pass  = password;

        setDebugMsg("Setting user name to : "+usern);
        setDebugMsg("Using given password : "+pass);

        props = new Properties();
        setDebugMsg("Setting smtp server: smtp.gmail.com");
        setDebugMsg("Using SSL at port 465 auth enabled");

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.user", usern);

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.debug", "true");

        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SMTPAuthenticator auth = new SMTPAuthenticator();
        session = Session.getDefaultInstance(props, auth);
        session.setDebug(true);
        setDebugMsg("Session initialization complete");
    }

    public void destroy() {
        props.clear();
        props = null;
        usern = null;
        pass  = null;
        session = null;

    }

    public void sendMailTo(String to, String sub, String body)
                                                    throws MessagingException {

         Calendar currentDate = Calendar.getInstance();
         SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss a"); 
         String dateToday = formatter.format(currentDate.getTime()).toLowerCase();

         if (to.equals("self")) 
             to = usern;

         setDebugMsg("Composing message: To "+to);
         setDebugMsg("Composing message: Subject "+sub);

         try {
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(usern));
             message.setRecipients(Message.RecipientType.TO, 
                                                    InternetAddress.parse(to));
             message.setSubject("PinguBot: "+dateToday+" "+sub);
             message.setText(body);
             setDebugMsg("Attempting to send...");
             Transport transport = session.getTransport("smtps");

             transport.connect("smtp.gmail.com", 465, usern, pass);
             Transport.send(message);
             transport.close();
         }

         catch(MessagingException me) {
             setDebugMsg(me.toString());
             throw new MessagingException(me.toString());
         }
             setDebugMsg("Mail was send successfully");
    }


    public String getDebugMsg() {
        String msg = new String(debugMsg);
        debugMsg = " ";
        return msg;
    }
    private static void setDebugMsg(String msg) {
        debugMsg += msg + "\n";
        System.out.println(msg);
    }

    private static String debugMsg = "";
    private String usern; 
    private String pass;
    private Session session;
    private static Properties props;

    private class SMTPAuthenticator extends Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(usern, pass);
        }
    }

}