public static void emailAttachment
              throws AddressException, MessagingException{

  String host = mail.company.com;
  String from = user@company.com;
  String to = user2@company.com;
  String cc = user3@company.com;

  Properties props = System.getProperties();

  props.put("mail.smtp.host", host);
  Session session = Session.getInstance(props, null);

  MimeMessage message = new MimeMessage(session);
  message.setFrom(new InternetAddress(from));
  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
  message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));

  message.setSubject("Email Notification");
  MimeBodyPart messageBodyPart = new MimeBodyPart();

  messageBodyPart.setText("email Body");

  Multipart multipart = new MimeMultipart();
  multipart.addBodyPart(messageBodyPart);
  messageBodyPart = new MimeBodyPart();
  DataSource source = new FileDataSource(fileAttachment);
  messageBodyPart.setDataHandler(new DataHandler(source));
  messageBodyPart.setFileName("attachment.pdf");
  multipart.addBodyPart(messageBodyPart);

  message.setContent(multipart);

  Transport.send( message );

}