private Session createSmtpSession() {
  final Properties props = new Properties();
  props.setProperty("mail.smtp.host", "smtp.gmail.com");
  props.setProperty("mail.smtp.auth", "true");
  props.setProperty("mail.smtp.port", "" + 587);
  props.setProperty("mail.smtp.starttls.enable", "true");
  // props.setProperty("mail.debug", "true");

  return Session.getDefaultInstance(props, new javax.mail.Authenticator() {

    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication("john.doe@gmail.com", "mypassword");
    }
  });
}