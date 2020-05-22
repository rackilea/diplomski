String host = "smtp.gmail.com";
String username = "user";
String password = "passwd";
Properties props = new Properties();
props.setProperty("mail.smtp.host", host);
props.setProperty("mail.smtp.ssl.enable", "true");
// set any other needed mail.smtp.* properties here
Session session = Session.getInstance(props);
MimeMessage msg = new MimeMessage(session);
// set the message content here
Transport.send(msg, username, password);