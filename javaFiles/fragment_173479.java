Properties props = System.getProperties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "work.mailing.es");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        Address[] destinataris = new Address[9];

        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Return-Receipt-To", s_correuOrigen);
        msg.addHeader("Disposition-Notification-To", s_correuOrigen);
        msg.setFrom(new InternetAddress(s_correuOrigen));

        String s_destinataris = "";
        for (int d=0; d<destinatarios.size(); d++) {
            s_destinataris+=destinatarios.get(d);
            if (d!=destinatarios.size()-1) {
                s_destinataris+=",";
            }
        }

        System.out.println("destinatarios: "+s_destinataris);

        destinataris  = InternetAddress.parse(s_destinataris, false);
        MimeMultipart multiParte = new MimeMultipart();

        BodyPart texto = new MimeBodyPart();
        texto.setContent(cuerpo, "text/html; charset=UTF-8");

        multiParte.addBodyPart(texto);

        msg.setContent(multiParte);

        msg.setRecipients(Message.RecipientType.TO, destinataris);
        msg.setSubject(asunto,"utf-8");

        Transport.send(msg);