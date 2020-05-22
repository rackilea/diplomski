public List<Chat> getChats(int userId, ArrayList<String> 
    chatIds, HashMap<String, Long> chats) {

    Log.i("chatRequest", TAG);

    ChatsRequest chatsRequest = new ChatsRequest.Builder(userId)
            .chatIDs(chatIds)
            .chats(chats)
            .build();

    return apiService.getChats(chatsRequest);
}