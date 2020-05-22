MimeBodyPart messageBodyPart=new MimeBodyPart();       
   messageBodyPart.setContent(emailBody, "text/html");

   // Add an attachment
   attachmentBodyPart = new MimeBodyPart();
   attachmentBodyPart.setDataHandler(new DataHandler(attachment));
   attachmentBodyPart.setFileName(attachment.getName());
   multipart.addBodyPart(attachmentBodyPart);
   // and so on...