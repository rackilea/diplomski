private static BodyPart createAttachment(filepath) {
    File file = new File(filepath);
    if (file.exists()) {
        DataSource source = new FileDataSource(file);
        DataHandler handler = new DataHandler(source);
        BodyPart attachment = new MimeBodyPart();
        attachment.setDataHandler(handler);
        attachment.setFileName(file.getName());
        return attachment;
    }
    return null; // or throw exception
}