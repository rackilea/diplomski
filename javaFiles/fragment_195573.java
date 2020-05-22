Message message = new MimeMessage(session);
        message.setSubject("Trial Messages");
        message.setFrom(new InternetAddress("trial@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("trial@yahoo.co.in"));

        MimeBodyPart body = new MimeBodyPart();
        body.setText(content);;
        Multipart part = new MimeMultipart();


        File f = new File("ABC.pdf");
        String s = f.getAbsolutePath();

        System.out.printf(s);

        DataSource source = new FileDataSource(s);
        body.setDataHandler(new DataHandler(source));
        body.setFileName("ABC Bill");
        part.addBodyPart(body);

        message.setContent(part);
        System.out.printf(s);
        Transport.send(message);

        System.out.printf(s);