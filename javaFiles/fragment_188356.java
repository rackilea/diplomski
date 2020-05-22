private String getStringActiveRooms(@NotNull ArrayList<Chat_room> c){
    final StringBuffer i = new StringBuffer();
    c.forEach( (chat_room) -> i.append(chat_room.getName() + "[" + chat_room.activeUsers() + "/" + chat_room.maxUsers() + "]" + ", "));

    return i.toString();

}