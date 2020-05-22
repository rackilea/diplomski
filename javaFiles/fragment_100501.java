private List<Message> getMessageID(Gmail service,
                              String query) throws IOException {
ListMessagesResponse response = service.users().messages().list("me").setQ(query).execute();

List<Message> messages = new ArrayList<Message>();
while (response.getMessages() != null) {
    messages.addAll(response.getMessages());
    if (response.getNextPageToken() != null) {
        String pageToken = response.getNextPageToken();
        response = service.users().messages().list("me").setQ(query)
                .setPageToken(pageToken).execute();
    } else {
        break;
    }
}
if(messages.isEmpty()) {
    getMessageID(service, query);
}
messageID = gson.toJson(messages);

return messages;
}

private Message getEmail(Gmail service, String userId, String messageId)
    throws IOException {
Message message = service.users().messages().get(userId, messageId).execute();

email = message.toString();

return message;
}

public void getGmailEmail() {
try {
    getMessageID(service, "after: " + unixTime);
    messageID = messageID.split("\",")[0].substring(8);
    getEmail(service,"me", messageID);
    System.out.println("Email received");
    emailOrThread = email;
} catch (IOException ignored) { }
}