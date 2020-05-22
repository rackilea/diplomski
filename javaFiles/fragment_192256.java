private void send(String toAddress, String subject, String text, byte[] attachment) {
  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
  mailSender.setHost(mailHost);

  MimeMessage message = mailSender.createMimeMessage();
  MimeMessageHelper msgHelper = new MimeMessageHelper(message, true);
  msgHelper.setSubject(subject);
  msgHelper.setFrom(fromAddress);
  msgHelper.setTo(toAddress);

  Multipart multipart = new MimeMultipart();

  MimeBodyPart messageBodyPart = new MimeBodyPart();
  messageBodyPart.setText(text, "UTF-8", "html");
  multipart.addBodyPart(messageBodyPart);

  MimeBodyPart imagePart = new MimeBodyPart();
  imagePart.attachFile(new File(PdfMailServiceImpl.class.getClassLoader().getResource("images/Energy_Office-logo.png").toURI()));
  imagePart.setContentID("<" + "101" + ">");
  imagePart.setDisposition(MimeBodyPart.INLINE);
  multipart.addBodyPart(imagePart);

  MimeBodyPart pdfPart = new MimeBodyPart();
  DataSource pdfSrc = new ByteArrayDataSource(attachment, mime);
  pdfPart.setDataHandler(new DataHandler(pdfSrc));
  pdfPart.setFileName(formFilename);
  multipart.addBodyPart(pdfPart);

  message.setContent(multipart, "text/html");

  message.saveChanges();

  mailSender.send(message);
}