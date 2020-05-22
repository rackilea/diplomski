public class B {

    public B(A aa) throws MessagingException {

        File file = aa.file;

        String host = "smtp.gmail.com";
        String Password = "***";
        String from = "***@gmail.com";
        String toAddress = "***@gmail.com";

        //Here i don t want to use this file
        //String filename = "C:/file.txt";

        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("Attachment TEST ");

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText("coucou the file is here");

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(file);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(file.getName());

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        try {
            Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }
    }
    public static void main(String args[]) throws MessagingException{

        A aaa = new A();
        B file = new B(aaa);
    }
}