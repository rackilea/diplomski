props.put("mail.smtp.auth", "true");
Session mailSession = Session.getDefaultInstance(properties, new Authenticator() {
    public PasswordAuthentication getPasswordAuthentication() {
       //Fill in your data here.
       return new PasswordAuthentication("user", "password");
    }
});