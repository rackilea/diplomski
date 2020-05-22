MimeBodyPart messageBodyPart = new MimeBodyPart();
//fill message
messageBodyPart.setContent(bodytext, type.type);

Multipart multipart = new MimeMultipart();
multipart.addBodyPart(messageBodyPart);
message.setContent(multipart);