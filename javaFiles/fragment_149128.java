MimeMessage mm = prepareMessage(from, to, subject, cc, bcc);
MimeMultipart mp = new MimeMultipart("alternative");

// Attach Plain Text
MimeBodyPart plain = new MimeBodyPart();
plain.setText(plainText);
mp.addBodyPart(plain);

/*
 * Any attached images for the HTML portion of the email need to be encapsulated with
 * the HTML portion within a 'related' MimeMultipart. Hence we create one of these and
 * set it as a bodypart for the overall message.
 */
MimeMultipart htmlmp = new MimeMultipart("related");
MimeBodyPart htmlbp = new MimeBodyPart();
htmlbp.setContent(htmlmp);
mp.addBodyPart(htmlbp);

// Attach HTML Text
MimeBodyPart html = new MimeBodyPart();
html.setContent(htmlText, "text/html");
htmlmp.addBodyPart(html);

// Attach template images (EmailImage is a simple class that holds image data)
for (EmailImage ei : template.getImages()) {
    MimeBodyPart img = new MimeBodyPart();
    img.setContentID(ei.getFilename());
    img.setFileName(ei.getFilename());
    ByteArrayDataSource bads = new ByteArrayDataSource(ei.getImageData(), ei.getMimeType());
    img.setDataHandler(new DataHandler(bads));
    htmlmp.addBodyPart(img);
}

mm.setContent(mp);