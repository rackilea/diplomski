m = javax.mail.internet.MimeMessage.new(your_SMTP_obtained_session);
 m.setFrom(javax.mail.internet.InternetAddress.new(from_who));
 m.setSubject("Message Receipt (displayed) - #{original_message_subject}");
 m.addRecipient(javax.mail.internet.MimeMessage::RecipientType::TO, 
    javax.mail.internet.InternetAddress.new(destination_email_address));
 multireport = com.sun.mail.dsn.MultipartReport.new("Your text message to the" +
    "recipient i.e report content",com.sun.mail.dsn.DispositionNotification.new);
 m.setContent(multireport);