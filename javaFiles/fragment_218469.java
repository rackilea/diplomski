try {
    Properties props = new Properties();
    props.put("mail.from", "one four four@@or.newer");
    Session s = Session.getInstance(props);
    new MimeMessage(s).setFrom();
} catch (MessagingException me) {
    Throwable cause = me.getNextException();
    if (cause == null) {
        System.err.println("JavaMail 1.4.3 or older.");
    } else if (cause instanceof AddressException) {
        System.err.println("JavaMail 1.4.4 or newer.");
    } else {
        me.printStackTrace();
    }
}