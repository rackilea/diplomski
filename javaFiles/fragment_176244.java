public void sendMail(){
    Properties properties = System.getProperties();
    final String USERNAME = from;
    final String PASSWORD = pass;

    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.user", from);
    properties.put("mail.smtp.password", pass);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    //properties.put("mail.debug", "true");

    Session session = Session.getDefaultInstance(properties);
    try {

        MimeMessage mime = new MimeMessage(session);
        mime.setFrom(new InternetAddress(USERNAME));

        mime.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mime.setSubject(subject);
        mime.setText(message);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, pass);
        transport.sendMessage(mime, mime.getAllRecipients());
        transport.close();
        LOGGER.log(Level.INFO, "Mail sent successfully");
    } catch (MessagingException e) {
        // TODO Auto-generated catch block
        LOGGER.log(Level.ERROR, "Unable to send mail\n");
    }   
}