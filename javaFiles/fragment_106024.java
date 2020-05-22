if ("true".equals(emailConfig.get("mail.smtp.auth"))) {
    session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(emailConfig.get("mail.smtp.user"), emailConfig.get("mail.smtp.password"));
        }
    });
}

Message msg = new MimeMessage(session);
msg.setFrom(new InternetAddress(emailFromAddress));
msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailToAdrress));
msg.setSubject(mailSubject);
msg.setText(mailMessageBody);
Transport.send(msg);