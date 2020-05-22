public void sendEmail(final String recipient, final String subject, final String bodyText, final String from) throws NotesException {

    final Session dominoSession = NotesFactory.createSession(dominoServer, dominoUsername, dominoPassword);
    final Database dominoDb = dominoSession.getDatabase(dominoServer, dominoMailbox);

    final Document mail = dominoDb.createDocument();
    mail.appendItemValue("Form", "Memo");
    mail.appendItemValue("Importance", "1");
    mail.appendItemValue("Subject", subject);
    mail.appendItemValue("Body", bodyText);
    mail.replaceItemValue("From", from + "@NotesDomain");
    mail.replaceItemValue("InetFrom", from);
    mail.send(false, recipient);

    dominoDb.recycle();
    dominoSession.recycle();
}