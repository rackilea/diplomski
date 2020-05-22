// Set the host SMTP address
Properties props = new Properties();
props.put("mail.transport.protocol", "smtp");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", hostname);
props.put("mail.smtp.port", "8025");
props.put("mail.smtp.auth", "true");

// creates a new session with an authenticator
Authenticator auth = new Authenticator() {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
};
Session session = Session.getInstance(props, auth);

Transport trans = session.getTransport("smtp");

//...piece of the code where message is created...

trans.connect();
try {
   trans.sendMessage(message, message.getAllRecipients());
} finally {
   trans.close();
}