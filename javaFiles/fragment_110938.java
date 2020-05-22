String autoReplyText = "Whats up";
boolean isAutoReply = msgs[i].getMessageBody().toString().equals(autoReplyText);

if (!isAutoReply) {
    sms.sendTextMessage(str2, null, autoReplyText, pi, null);
}