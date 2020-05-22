MimeMessage message = new MimeMessage(session);
MimeMultiPart multiPart = new MimeMultiPart();

MimeBodyPart messageBodyPart = new MimeBodyPart();
messageBodyPart.setText(body);
multiPart.addBodyPart(messageBodyPart);

MimeBodyPart attachment = new MimeBodyPart();
attachment.setDataHandler(new DataHandler(source));
attachment.setDisposition(Part.ATTACHMENT);
attachment.setFileName(pdf.getName().toString());
multipart.addBodyPart(attachment);

message.setContent(multiPart);