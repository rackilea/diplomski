private static void addAttachment(Multipart multipart, String filename)
{
    DataSource source = new FileDataSource(filename);
    BodyPart messageBodyPart = new MimeBodyPart();        
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(filename);
    multipart.addBodyPart(messageBodyPart);
}