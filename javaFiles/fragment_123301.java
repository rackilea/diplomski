public static void addAttachment(Message msg, File attachment) throws Exception {
    //Create the new body part and add the file
    MimeBodyPart attachment = new MimeBodyPart();
    DataSource source = new FileDataSource(file);
    attachment.setDataHandler(new DataHandler(source));
    attachment.setFileName(file.getName());

    //Add the new body part to the e-mail
    msg.getContent().addBodyPart(attachment);
}