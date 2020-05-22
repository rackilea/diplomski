ArrayList<HashMap<String, String>> receivedMessages = getAllMessages();
Iterator<HashMap<String, String>> iterator = receivedMessages.iterator();
HashMap<String, List<String>> messages = new HashMap<>();
while (iterator.hasNext()) {
HashMap<String, String> map = iterator.next();
addToMap(messages, map.get("sender"),map.get("_ID"));
addToMap(messages, map.get("recipient"),map.get("_ID"));
addToMap(messages, map.get("keyword"),map.get("_ID"));