public static void main(String[] args) {

    // Recipient's email ID needs to be mentioned.
    String to = "<to email>";

    // Sender's email ID needs to be mentioned
    String from = "<from email>";

    final String username = "<email server username>";// change accordingly
    final String password = "<email server password>";// change accordingly

    // Set to your email server
    String host = "mail.acme.com";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "false");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "25");

    // Get the Session object.
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

        // Set Subject: header field
        message.setSubject("Testing Subject");

        // Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();

        // Now set the actual message
        messageBodyPart.setText("Hello. Attached is a very important PDF.");

        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = "/Users/rick/Tmp/test.pdf";

        DataSource source;
        try (InputStream inputStream = new FileInputStream(filename)) {
            source = new ByteArrayDataSource(inputStream, "application/pdf");
        }

        printDataSourceByteCount(source);

        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("SecretsOfTheUniverse.pdf");
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);

        // Send message
        Transport.send(message);

        System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
        // TODO handle the error
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        // TODO handle the error
        e.printStackTrace();
    } catch (IOException e) {
        // TODO handle the error
        e.printStackTrace();
    }
}