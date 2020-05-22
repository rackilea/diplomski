NotesUIElement elem = (new NotesUIWorkspace()).getCurrentElement();
if (elem instanceof NotesUIDocument) {
NotesUIDocument doc = ((NotesUIDocument) elem);
String to = doc.getField("EnterSendTo").getText();
String cc = doc.getField("EnterCopyTo").getText();
String bcc = doc.getField("EnterBlindCopyTo").getText();
String subject = doc.getField("Subject").getText();
String body = doc.getField("Body").getText();
    ....
 }