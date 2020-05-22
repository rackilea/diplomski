public void sendMail(){//This will actually attempt to send the email successfully
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(SUBJECT);
            message.setText(MESSAGE);
            Transport.send(message, message.getAllRecipients());
        }
        catch(MessagingException e){
            System.out.println("send failed, exception: " + e);
        }
        System.out.println("Sent!!!!");
    }
}