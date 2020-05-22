public void sendMail(final String senderEmailID, final String password, javax.mail.Address [] addresses) {
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = null;
    try {
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmailID, password);
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
        return;
    }

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmailID));
        message.setRecipients(Message.RecipientType.TO, addresses);

        message.setSubject("Subject");

        String messageBody = "<h1>Message</h1>";

        message.setContent(messageBody.toString(), "text/html");
        Transport.send(message);
    } catch (Exception e) {
        e.printStackTrace();
    }
}