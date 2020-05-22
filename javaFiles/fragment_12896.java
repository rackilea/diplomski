public class MailMan {
Session session = null;

public MailMan() {
    if (session == null) {
        init();
    }
}

public void init() {

    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("EMAIL", "PASSWORD");
        }
    });
    if (session != null) {
        System.out.println("[OK]");
    } else {
        System.out.println("[NOK]");
    }
}

public void sendMail() {
    if (session == null) {
        System.exit(0);
    }
    try {
        String messageText = "";
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("no-reply", "No Reply"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        message.setReplyTo(InternetAddress.parse("no-reply"));


        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("to_email")); 
        message.setSubject("TEST");
        message.setText(messageText);

        Transport.send(message);

        System.out.println("[OK]");

    } catch (MessagingException e) {
        e.printStackTrace();
        System.out.println("Not Sent...");
    }
 }
}