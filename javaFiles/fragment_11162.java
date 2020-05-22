@Autowired
private JavaMailSender mailSender;

 private void sendMail(String to, String subject, String bodyPlainText, String bodyHtml, String contentId, String base64Image) {
    try {
        MimeMessage message = mailSender.createMimeMessage();
        message.setSubject(subject);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent(bodyPlainText, "text/plain; charset=UTF-8");

        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(bodyHtml, "text/html; charset=UTF-8");

        Multipart multiPart = new MimeMultipart("alternative");

        // create a new imagePart and add it to multipart so that the image is inline attached in the email
        byte[] rawImage = Base64.getDecoder().decode(base64Image);
        BodyPart imagePart = new MimeBodyPart();
        ByteArrayDataSource imageDataSource = new ByteArrayDataSource(rawImage,"image/png");

        imagePart.setDataHandler(new DataHandler(imageDataSource));
        imagePart.setHeader("Content-ID", "<qrImage>");
        imagePart.setFileName("someFileName.png");

        multiPart.addBodyPart(imagePart);
        multiPart.addBodyPart(textPart);
        multiPart.addBodyPart(htmlPart);

        message.setContent(multiPart);

        mailSender.send(message);
    } catch (MessagingException exception) {
        //log error
    }
}