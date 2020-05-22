String text = "<h1>Hello My HTML formatted message</h1>";
String to = email_id_of_recipients;
MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(from));
message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
message.setSubject("My resume");
// message.setText(text, "utf-8", "html");

MimeBodyPart textPart = new MimeBodyPart();
textPart.setContent(text, "text/html; charset=utf-8");

DataSource source = new FileDataSource(filename);
MimeBodyPart messageBodyPart = new MimeBodyPart();
messageBodyPart = new MimeBodyPart();
messageBodyPart.setDataHandler(new DataHandler(source));
messageBodyPart.setFileName(filename);
Multipart multipart = new MimeMultipart("mixed");
multipart.addBodyPart(textPart);
multipart.addBodyPart(messageBodyPart);
message.setContent(multipart);

Transport.send(message);