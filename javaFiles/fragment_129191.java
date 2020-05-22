Session mailSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("yourmail@gmail.com", "yourpassword");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setContent(content, "text/html");

        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(emailid));

        transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, "yourmail@gmail.com", "yourpassword");

        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));

        transport.close();