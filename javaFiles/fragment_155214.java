public List<Message> getMessageByAuthor(String authorName) { 
    List<Message> nameList = new ArrayList<Message>(messages.values());
    List<Message> responseMessageList = new ArrayList<>();
    Message message = null;
    if (!authorName.isBlank()) {
        Iterator<Message> iterator = nameList.iterator();
        while (iterator.hasNext()) {
            message = iterator.next();
            if (message.getMessageAuthor().contains(authorName)) {
                 responseMessageList.add(message);
            }
        }
    }
    return responseMessageList;
}