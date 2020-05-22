public static void main(String[] args) throws Exception {

    Session session;
    String user = "test1";
    String password = "pwd1";

    String fromAddress = "test1@localhost"; // newlycreateduser@localhost
    String toAddress = "test1@localhost";

    // Create a mail session
    Properties properties = System.getProperties();
    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.transport.protocol.rfc822", "smtp");
    properties.put("mail.smtp.host", "localhost");
    properties.put("mail.smtp.port", "3025");
    properties.put("mail.debug", "true");
    properties.put("mail.smtp.localaddress", "127.0.0.1");
    session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("test1", "pwd1");
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromAddress));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
        message.setSubject("Email From my Greenmail");
        message.setText("Test Mail sent from My Greenmail!!");
        message.addHeader("X-THALES-ID", "1");
        message.addHeader("X-ROUTE-TO", "thalestest");
        message.addHeader("X-GROUND-TYPE", "GROUND");
        message.addHeader("X-ORIGINAL-FROM", "ambatltesttool");
        message.addHeader("X-EMBATL-ERROR", "");
        Transport.send(message);


        System.out.println("Email sent successfully from greenmail");
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}