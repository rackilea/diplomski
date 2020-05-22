Properties props = new Properties();
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.starttls.required", "true");
                        props.put("mail.smtp.sasl.enable", "false");
                        Session session = Session.getInstance(props);
                        //session.setDebug(true);


                        final URLName unusedUrlName = null;
                        SMTPTransport transport = new SMTPTransport(session, unusedUrlName);
                        // If the password is non-null, SMTP tries to do AUTH LOGIN.
                        transport.connect("smtp.gmail.com", 587, userId, emptyPassword);

                        byte[] response = String.format("user=%s\1auth=Bearer %s\1\1", userId,
                                spreadsheet.accessToken).getBytes();
                        response = BASE64EncoderStream.encode(response);

                        transport.issueCommand("AUTH XOAUTH2 " + new String(response),
                                235);

                        MimeMessage message = new MimeMessage(session);
                        DataHandler handler = new DataHandler(new ByteArrayDataSource(messageBody.getBytes(), "text/plain"));   
                                message.setSender(new InternetAddress(fromEmail));   
                                message.setSubject(messageSubject);   
                                message.setDataHandler(handler);   
                            message.setRecipient(Message.RecipientType.TO, new InternetAddress(messageToAddress));   
                        transport.sendMessage(message, message.getAllRecipients());   

                        System.out.println("SentTo:"+messageToAddress);