Message message = new MimeMessage(session);
message.setFrom(new InternetAddress(from));
message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));
message.setSubject(subject);
message.setText(messageText);
Transport.send(message);