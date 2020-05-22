MimeMessage msg = new MimeMessage(session);
msg.setSubject("yourSubject", "UTF-8"); // here you specify your subject encoding
msg.setContent("yourBody", "text/plain; charset=utf-8");

msg.setFrom("senderAddress");
msg.addRecipient(Message.RecipientType.TO, "recieverAddress");
Transport.send(msg);