Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("email0@gmail.com"));
    message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("email0@gmail.com"));
    message.setSubject("Attach file Test from Netbeans");

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText("PFA");

    attachmentBodyPart = new MimeBodyPart();

    System.out.println("The filetosend is ="+filetosend);
    System.out.println("The source is ="+source);

    attachmentBodyPart.attachFile(filetosend);
    System.out.println("The file name is ="+attachmentBodyPart.getFileName());

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    multipart.addBodyPart(attachmentBodyPart);

    message.setContent(multipart);
    System.out.println("The message multi part is ="+multipart);

    System.out.println("Sending");

    Transport.send(message);