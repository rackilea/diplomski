String autoReplyToken = "[BANANA]";
String autoReplyText = autoReplyToken + " dynamic message content";

boolean isAutoReply = msgs[i].getMessageBody().toString().startsWith(autoReplyToken);

if (!isAutoReply) {
    sms.sendTextMessage(str2, null, autoReplyText, pi, null);
}