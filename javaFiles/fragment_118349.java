public class EmailSender{

    public void send(){
      //javamail code
      Session mailSession = createSmtpSession();
      //javamail code
    }

    private Session createSmtpSession() {
        final Properties props = new Properties();
        props.setProperty ("mail.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty ("mail.transport.protocol", "smtp");
        // props.setProperty("mail.debug", "true");

        return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    "<gmail ID in user@domain format goes here>", 
                    "<password goes here>");
            }
        });
    }
}