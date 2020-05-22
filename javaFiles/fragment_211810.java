public void sendEmail(final String to, final String from, final String cc, final String subject, final String body,
        final String baseDirectory, final List<String> listOfFileNames) {
    for (int i = 1; i <= 3; i++) { // retrying
        try {
            Session session = Session.getInstance(mailProperties, null);

            Multipart multipart = new MimeMultipart("related");
            MimeBodyPart bodyPart= new MimeBodyPart();

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            InternetAddress[] toAddress = InternetAddress.parse(to);
            InternetAddress[] ccAddress = InternetAddress.parse(cc);

            message.addRecipients(RecipientType.TO, toAddress);
            message.addRecipients(RecipientType.CC, ccAddress);
            message.setSubject(subject);

            bodyPart.setText(body, "UTF-8", "html");
            multipart.addBodyPart(bodyPart);

            for (String file : listOfFileNames) {
                String fileLocation = baseDirectory + "/" + file;
                addAttachment(multipart, fileLocation, file);
            }
            message.setContent(multipart);
            Transport.send(message, toAddress);
            break;
        } catch (Exception ex) {
            // log exception
        }
    }
}

// this is used for attachment
private void addAttachment(final Multipart multipart, final String filepath, final String filename) throws MessagingException {
    DataSource source = new FileDataSource(filepath);
    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(filename);
    multipart.addBodyPart(messageBodyPart);
}