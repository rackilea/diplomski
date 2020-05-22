javax.mail.Multipart multipart = new MimeMultipart();

javax.mail.internet.MimeBodyPart messageBodyPart =   new  javax.mail.internet.MimeBodyPart();

multipart.addBodyPart(messageBodyPart);

javax.activation.DataSource source = new FileDataSource("C:\\Notes\\new mail.msg");

messageBodyPart.setDataHandler( new DataHandler(source));
messageBodyPart.setFileName("new mail.msg");

multipart.addBodyPart(messageBodyPart);
msg.setContent(multipart);

 MimeBodyPart part = new MimeBodyPart();
 part.setText(text);

multipart.addBodyPart(part);