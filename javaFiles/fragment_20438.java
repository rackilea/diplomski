try{
   Statement stmt = connection.createStatement();
   .......................
} catch (Exception e) {
     String host = "smtp.google.com";
     String sender= "fromEmail@gmail.com";
     String recipiant = "toEmail@mail.com";

     StringWriter tracewriter = new StringWriter();
     e.printStackTrace(tracewriter);
     String trace = tracewriter.toString();

     Properties props= System.getProperties();
     props.setPropertie("mail.smtp.host", host);

     Session session = Session.getDefaultInstance(props);

     try{
         MineMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(sender));
         message.addRecipiant(Message.RecipiantType.TO, new InternetAddress(recipiant));
         message.setSubject("Testing Error");
         message.setText(trace);

         Transport.send(message);
         System.out.println("An administrator has been notified");
     } catch (Exception ex) {
         ex.printStackTrace();
     }
}