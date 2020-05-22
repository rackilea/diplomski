Folder inbox = store.getFolder("INBOX");
inbox.open(Folder.READ_ONLY);

SearchTerm sender = new FromTerm(new InternetAddress("from@example.com"));
Message[] messages = inbox.search(sender);

for (int i = 1; i < messages.length; i++) {
    read_message(messages[i]);
}