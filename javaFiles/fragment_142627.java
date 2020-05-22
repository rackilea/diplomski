Session mailSession = Session.getInstance(props);   
Store mailStore = mailSession.getStore("imap");
mailStore.connect(<host>, <user>, <passwd>);                    
Folder dFolder = mailStore.getDefaultFolder();
Folder inbox = dFolder.getFolder(<connectFolder=INBOX?>);
inbox.open(Folder.READ_WRITE);

 // Open destination folder, create if reqd
Folder destfolder = mailStore.getFolder(<destination folder>);
if (!destfolder.exists())
   destfolder.create(Folder.HOLDS_MESSAGES);

Message []inMessages = inbox.getMessages();
if (inMessages .length != 0) {
    inbox.copyMessages(inMessages , destfolder);

    for (int i=0; i< inMessages.length; i++) { 
      // Custom Processor which readsMessages and performs some action.
      // getProcessor().readMessage(inMessages[i]);
       inMessages[i].setFlag(Flags.Flag.DELETED, true);
    }
}