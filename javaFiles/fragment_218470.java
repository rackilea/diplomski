try {
    Properties props = new Properties();
    Session s = Session.getInstance(props);
    new MimeMessage(s).setRecipients(Message.RecipientType.TO, (String) null);
    System.err.println("JavaMail 1.4.5 or newer.");
} catch (NullPointerException me) {
    System.err.println("JavaMail 1.4.4 or older.");
}