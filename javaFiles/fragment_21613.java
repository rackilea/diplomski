public Map<String, Conversation> getAllConversations() {
  final Map<String, Conversation> conversations = new HashMap<>();

  Cursor cursor = ...;
  while (cursor.moveToNext()) {
    Conversation conversation = new Conversation();
    ...
    conversations.put(conversation.getSender(), conversation);
  }
  cursor.close(); // don't forget to close your cursors!

  return conversations;
}