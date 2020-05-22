Session sesion = Session.getInstance(System.getProperties());
Store store = sesion.getStore("imap");
store.connect(host, user, passwd);
Folder inbox = store.getFolder("INBOX");
inbox.open(Folder.READ_WRITE);

// Convert to MimeMessage after search 
MimeMessage[] messages = (MimeMessage[]) carpetaInbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
for (int i = 0 ; i< messages.length ; i++){
    // Create a new message using MimeMessage copy constructor
    MimeMessage cmsg = new MimeMessage(messages[i]);
    // Use this message to read its contents 
    Object obj = cmsg.getContent(); 
// ....
}