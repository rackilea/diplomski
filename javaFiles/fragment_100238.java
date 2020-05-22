if (arrayInputStream != null && arrayInputStream instanceof ByteArrayInputStream) {
    // create the second message part with the attachment from a OutputStrean
    MimeBodyPart attachment= new MimeBodyPart();
    ByteArrayDataSource ds = new ByteArrayDataSource(arrayInputStream, "application/pdf"); 
    attachment.setDataHandler(new DataHandler(ds));
    attachment.setFileName("Report.pdf");
    mimeMultipart.addBodyPart(attachment);
}