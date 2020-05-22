msg.setFrom(new InternetAddress(FROM_EMAIL));
    InternetAddress[] address = {new InternetAddress(
        TO_EMAIL)};
    msg.setRecipients(Message.RecipientType.TO, address);
    msg.setSubject("Test Subject");
    msg.setSentDate(new Date());

    MultipartSigned multiSigned = new MultipartSigned();

    // create and fill the first message part
    MimeBodyPart bodyPart1 = new MimeBodyPart();

    bodyPart1.setText("<b>Hello World</b>", "utf-8", "html");

    Multipart multiPart = new MimeMultipart();
    multiPart.addBodyPart(bodyPart1);

    // add other content to the inner multipart here

    MimeBodyPart body = new MimeBodyPart();
    body.setContent(multiPart);
    multiSigned.addBodyPart(body);

    try (OutputStream str = Files.newOutputStream(Paths
            .get(UNSIGNED_MIME))) {
        body.writeTo(str);
    }

    signMime();

    MimeBodyPart attachPart = new MimeBodyPart();

    String filename = SIGNED_VALUE;

    attachPart.attachFile(filename,
            "application/pkcs7-signature; name=smime.p7s", "base64");
    attachPart.setFileName("smime.p7s");
    attachPart.addHeader("Content-Description",
            "S/MIME Cryptographic Signature");

    multiSigned.addBodyPart(attachPart);
    msg.setContent(multiSigned);

    msg.saveChanges();