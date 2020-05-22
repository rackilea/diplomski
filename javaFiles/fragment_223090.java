int unprocessedMessagesCount = 0;
boolean hasAttachment = false;

for (MessageInfo messageInfo: messageInfoList) {
  if (messageInfo.getProcessedDate() == null) {
    unprocessedMessagesCount++;
  }
  if (hasAttachment == false && messageInfo.getAttachmentCount() > 0) {
    hasAttachment = true;
  }
}