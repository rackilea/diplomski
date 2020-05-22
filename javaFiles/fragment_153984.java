Map addChatMap = new HashMap();
  addChatMap.put("Seen",false);
  addChatMap.put("TimeStamp",ServerValue.TIMESTAMP);

Map chatUsersMap= new HashMap();
  chatUsersMap.put("Chat/"+ currentUserID + "/" + chatUser,chatUsersMap);
  chatUsersMap.put("Chat/"+ chatUser + "/" + currentUserID,chatUsersMap);