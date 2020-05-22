BodyPart messageBodyPart = new MimeBodyPart();
    String htmlText = message + "<img src=\"cid:image123\">";
    messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");

    MimeMultipart mpRelated = new MimeMultipart("relative");
    mpRelated.addBodyPart(messageBodyPart);

    BodyPart imageBodyPart = new MimeBodyPart();
    String file = this.getClass().getClassLoader().getResource("images/Logo.gif").getFile();
    DataSource fds = new FileDataSource(file);
    imageBodyPart.setFileName("Logo.gif");
    imageBodyPart.setHeader("Content-ID","<image123>");
    imageBodyPart.setDisposition(Part.INLINE);

    mpRelated.addBodyPart(imageBodyPart);

    MimeMultipart mpMixed = new MimeMultipart("mixed");
    //Nest Related into mixed
    BodyPart relatedInMixed = new MimeBodyPart();
    relatedInMixed.setContent(mpRelated);
    mpMixed.addBodyPart(relatedInMixed);

    //TODO Add attachement to mpMixed