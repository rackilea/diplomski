public class Emailer  //Class names should always be capitalized
{

private static String host = "smtp.gmail.com";
private static String user = "**********";
private static String pass = "***********";

public static void sendEmail(String fromAddr, String toAddr, String subject, String body)
{
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session.getInstance(props, null);

    MimeMessage message = new MimeMessage(session);

    try
    {
        message.setFrom(new InternetAddress(fromAddr));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddr));
        message.setSubject(subject);
        message.setText(body);
        Transport.send(message, user, pass);
    }
    catch (AddressException e) {e.printStackTrace();}
    catch (MessagingException e) {e.printStackTrace();}
}