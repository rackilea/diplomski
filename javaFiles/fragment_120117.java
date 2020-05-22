Map<Author, List<Message>> userGroup = new HashMap<>();
for (Message message : messages) {
    List<Message> userMessages = userGroup.get(message.author);
    if (userMessages == null) {
        userMessages = new ArrayList<>();
        userGroup.put(message.author, userMessages);
    }
    userMessages.add(message);
}
for (Entry<Author, List<Message>> entry : userGroup.entrySet()) {
    System.out.println(entry.getKey().getId());
    for (Message message : entry.getValue()) {
        System.out.println("\t" + message.date);
    }
}