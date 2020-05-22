properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.port", "587");

    Session session = Session.getDefaultInstance(properties,  
               new javax.mail.Authenticator() {  
               protected PasswordAuthentication getPasswordAuthentication() {  
               return new PasswordAuthentication("yourEmail","yourpassword");//change accordingly  
               }  
              });

    MimeMessage message=new MimeMessage(session);
    try {
        InternetAddress headers=new InternetAddress();
        message.setFrom(new InternetAddress("youremail"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(uEmail));
        message.setSubject("Welcome \n your email:"+uEmail);


        message.setText(html, "UTF-8", "html");

        Transport.send(message);
System.out.println("msg success ");
    } catch (AddressException e) {

        e.printStackTrace();
    } catch (MessagingException e) {

        e.printStackTrace();
    }


}