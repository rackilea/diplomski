public void email() {
    String smtpHost = "yourhost.com"; //replace this with a valid host
    int smtpPort = 587; //replace this with a valid port

    String sender = "sender@yourhost.com"; //replace this with a valid sender email address
    String recipient = "recipient@anotherhost.com"; //replace this with a valid recipient email address
    String content = "dummy content"; //this will be the text of the email
    String subject = "dummy subject"; //this will be the subject of the email

    Properties properties = new Properties();
    properties.put("mail.smtp.host", smtpHost);
    properties.put("mail.smtp.port", smtpPort);     
    Session session = Session.getDefaultInstance(properties, null);

    ByteArrayOutputStream outputStream = null;

    try {           
        //construct the text body part
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText(content);

        //now write the PDF content to the output stream
        outputStream = new ByteArrayOutputStream();
        writePdf(outputStream);
        byte[] bytes = outputStream.toByteArray();

        //construct the pdf body part
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("test.pdf");

        //construct the mime multi part
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(textBodyPart);
        mimeMultipart.addBodyPart(pdfBodyPart);

        //create the sender/recipient addresses
        InternetAddress iaSender = new InternetAddress(sender);
        InternetAddress iaRecipient = new InternetAddress(recipient);

        //construct the mime message
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setSender(iaSender);
        mimeMessage.setSubject(subject);
        mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
        mimeMessage.setContent(mimeMultipart);

        //send off the email
        Transport.send(mimeMessage);

        System.out.println("sent from " + sender + 
                ", to " + recipient + 
                "; server = " + smtpHost + ", port = " + smtpPort);         
    } catch(Exception ex) {
        ex.printStackTrace();
    } finally {
        //clean off
        if(null != outputStream) {
            try { outputStream.close(); outputStream = null; }
            catch(Exception ex) { }
        }
    }
}