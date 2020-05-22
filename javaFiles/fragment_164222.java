MimeMessage msg = new MimeMessage(session);
msg.setHeader("Content-Type", encodingOptions);
msg.setFrom(new javax.mail.internet.InternetAddress(emailFrom));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));

msg.setSubject(subject, "UTF-8");