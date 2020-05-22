public GroupChat getDataAfterButtonPress() {
    GroupChat chat = new GroupChat();
    chat.setParticipants(participants);
    chat.setMyId(userId);
    chat.setOtherID(id);
    chat.setMessage(message);
    return chat;
}