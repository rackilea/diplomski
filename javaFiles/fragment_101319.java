MimeBodyPart mbp1 = new MimeBodyPart();
    mbp1.setContent(body, "text/html");
    Multipart mp = new MimeMultipart();
    mp.addBodyPart(mbp1);

    msg.setContent(mp, "text/html");