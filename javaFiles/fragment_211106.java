private void createSession() {
    properties.put("mail.smtp.auth", "false");
     //Put below to false, if no https is needed
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", server);
    properties.put("mail.smtp.port", port);

    session = Session.getInstance(properties);
}