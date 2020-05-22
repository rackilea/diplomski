for(int i = 0; i < cc.length; i++) {
    if(!cc[i].isEmpty())
        message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
}
for(int i = 0; i < bcc.length; i++) {
    if(!bcc[i].isEmpty())
        msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
}