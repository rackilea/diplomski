String host = "smtp.live.com";
int port = 587;
String username = "you@live.com";
String password = "yourpassword";

Properties props = new Properties();
props.put("mail.smtp.host", host);
props.put("mail.smtp.port", String.valueOf(port));
Session mailSession = Session.getDefaultInstance(props);
Transport transport = null;

try {
    transport = mailSession.getTransport("smtp");
    transport.connect(host, username, password);
    InternetAddress fromAddress = new InternetAddress(from);

    for (Student s : groep.getStudenten()) {
        InternetAddress[] toAddresses = { new InternetAddress(s.getEmail()) };
        Message simpleMessage = new MimeMessage(mailSession);
        simpleMessage.setFrom(fromAddress);
        simpleMessage.setRecipients(RecipientType.TO, toAddresses);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(message);
        simpleMessage.setSentDate(new Date()); // Otherwise you end up in junk.
        simpleMessage.saveChanges(); // Transport#sendMessage() doesn't do it.
        transport.sendMessage(simpleMessage, toAddresses);
    }
} catch (MessagingException e) {
    // Handle it! Display a FacesMessage or something.
} finally {
    if (transport != null) try { transport.close(); } catch (MessagingException ignore) {}
}