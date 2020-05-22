private String outgoingMailServer = "smtp.mail.yahoo.com";    
boolean debug = false;

//set the host outgoing mail smtp server.
Properties properties = new Properties();
properties.put("mail.smtp.host", outgoingMailServer);
properties.put("mail.smtps.auth", "true");

Authenticator authenticator = new SMTPAuthentication();
Session session = Session.getDefaultInstance(properties, authenticator);
session.setDebug(debug);

//create a message session
Message msg = new MimeMessage(session);

//set the addresses, to and from
InternetAddress fromAddress;
fromAddress = new InternetAddress(emailFromAddress);
msg.setFrom(fromAddress);

//since mail can be sent to more than one recipient, create loop
//to add all addresses into InternetAddress, addressTo.
//InternetAddress[] toAddress = new InternetAddress[recipients.length];
InternetAddress[] toAddress = new InternetAddress[recipients.size()];
for (int i = 0; i < recipients.size(); i++) {
    toAddress[i] = new InternetAddress(recipients.get(i));
}
msg.setRecipients(Message.RecipientType.TO, toAddress);

//set the subject and content type
msg.setSubject(emailSubject);
msg.setContent(actualMessage, "text/html; charset=utf-8");

//send the email
Transport transport = session.getTransport("smtps");
transport.connect(outgoingMailServer, 465, emailUserName, emailPassword);
transport.sendMessage(msg, msg.getAllRecipients());
transport.close();

//email sent
//note, this does not necessarily mean the email was delivered. The
//sysetm has no control over that
emailSent = true;