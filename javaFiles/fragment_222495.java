public static void sendEmail(Email mail) {

String host = "smtp.gmail.com";
String from = "YOUR_GMAIL_ID";
String pass = "YOUR_GMAIL_PASSWORD";
Properties props = System.getProperties();
props.put("mail.smtp.starttls.enable", "true"); // added this line
props.put("mail.smtp.host", host);
props.put("mail.smtp.user", from);
props.put("mail.smtp.password", pass);
props.put("mail.smtp.port", "587");
props.put("mail.smtp.auth", "true");

// Get the default Session object.
Session session = Session.getDefaultInstance(props, null);

try {
    // Create a default MimeMessage object.
    MimeMessage message = new MimeMessage(session);

    // Set sender
    message.setFrom(new InternetAddress("Senders_EMail_Id"));

    // Set recipient
    message.addRecipient(Message.RecipientType.TO, new InternetAddress("RECIPIENT_EMAIL_ID"));

    // Set Subject: header field
    message.setSubject("SUBJECT");

    // set content and define type
    message.setContent("CONTENT", "text/html; charset=utf-8");

    Transport transport = session.getTransport("smtp");
    transport.connect(host, from, pass);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  } catch (MessagingException mex) {
    System.out.println(mex.getLocalizedMessage());
}