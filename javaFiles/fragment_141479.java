MimeBodyPart imgBP = new MimeBodyPart();
    DataSource fds = new FileDataSource(imgPath);
    imgBP.setDataHandler(new DataHandler(fds));
    imgBP.setHeader("Content-ID", "<image>");
    mmp.addBodyPart(imgBP);

    signature = signature.replaceFirst("(src=)([\"|\'])(.*)([\"|\'])", 
    "$1$2cid:image$4"); 
    MimeBodyPart body = new MimeBodyPart();
    body.setDisposition(MimePart.INLINE);
    body.setContent("<br><br><br>" + signature, "text/html");
    mmp.addBodyPart(body);