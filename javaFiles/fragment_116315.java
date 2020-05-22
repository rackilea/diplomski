Session session = Session.getInstance(props);
try (InputStream str = Files.newInputStream(Paths.get("message.eml"))) {
    MimeMessage msg = new MimeMessage(session, str);
    // Do something with the message, maybe send it.
    Transport.send(msg);
}