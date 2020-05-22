public int sendMailWithAttachment(String to, String subject, String body, String filepath, String sendFileName) {
    final String username = "YOUR EMAIL";
    final String password = "YOUR PWD";
    Properties props = new Properties();
    props.put("mail.smtp.user", username);
    props.put("mail.smtp.host", "smtp.live.com");
    props.put("mail.smtp.port", "25");
    props.put("mail.debug", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.EnableSSL.enable", "true");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.socketFactory.port", "587");
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);
        BodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        BodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent("<html><body>HELLO</body></html>", "text/html");
        DataSource source = new FileDataSource(filepath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(sendFileName);
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(htmlPart);
        message.setContent(multipart);
        Transport.send(message);
        return 1;
    } catch (Exception e) {
        return 0;
    }
}