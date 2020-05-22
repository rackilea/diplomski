
String host = "smtp.tctinfotech.com";
//host = smtp_server; //"smtp.gmail.com"; user = jsp_email; //"YourEmailId@gmail.com" // email id to send the emails
//pass = jsp_email_pw; //Your gmail password
String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
String to_add = request.getParameter("receiver");
String subject =request.getParameter("subject"); 
String messageText =request.getParameter("body"); 
String password = request.getParameter("pwd");
String from =request.getParameter("email_id");
boolean sessionDebug = true;
Properties props = System.getProperties();
props.put("mail.host", host);
props.put("mail.transport.protocol.", "smtp");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.", "true");
props.put("mail.smtp.port", "465");
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
Session mailSession = Session.getDefaultInstance(props, null);
mailSession.setDebug(sessionDebug);
Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = { new InternetAddress(to_add) };
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
msg.setContent(messageText, "text/html"); // use setText if you want to send text
Transport transport = mailSession.getTransport("smtp");
System.setProperty("javax.net.ssl.trustStore", "conf/jssecacerts");
System.setProperty("javax.net.ssl.trustStorePassword", "admin");
transport.connect(host, from, password);
try 
{
    transport.sendMessage(msg, msg.getAllRecipients());
    out.println("sent");
    //WasEmailSent = true; // assume it was sent
}
catch (Exception err) 
{
    //WasEmailSent = false; // assume it's a fail
    out.println("Error" + err.getMessage());
}
transport.close();