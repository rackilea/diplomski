public boolean sendMessageTo() {

    Authenticator auth = new Authenticator() {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            LOG.info("Create authenticator class and return PasswordAuthenticator");
            return new PasswordAuthentication(props.getProperty("username"), props.getProperty("username"));
        }
    };

    Session session = Session.getInstance(props, auth);

    Message message = new MimeMessage(session);

    boolean succes = false;

    try {
        message.setFrom(new InternetAddress(props.getProperty("username")));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipientEmailAddress));
        message.setSubject("Testing mail");
        message.setText("Weclome companion!,\n" + messageText
                + "\n You wonn premmum code for redtube.com ;)");
        Transport.send(message);
        succes = true;
    } catch (AddressException ax) {
        System.err.println(ax);
    } catch (MessagingException me) {
        System.err.println(me);
    } finally {
        return succes;
    }
}