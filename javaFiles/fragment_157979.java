Multipart multipart = new MimeMultipart();
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    String message = "file attached. ";
    messageBodyPart.setText(message, "utf-8", "html");
    multipart.addBodyPart(messageBodyPart);

    MimeBodyPart attachmentBodyPart = new MimeBodyPart();
    attachmentBodyPart.attachFile(new File(filePath+"/"+fileName), "application/pdf", null);
    multipart.addBodyPart(attachmentBodyPart);
    mail.setContent(multipart);