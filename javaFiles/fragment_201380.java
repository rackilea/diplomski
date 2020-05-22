"SELECT oneChat from " + Chat.class.getName() + " oneChat "
                + " left join fetch oneChat.user1 " 
                + " left join fetch oneChat.user2 "
                + " left join fetch oneChat.user3 "
                + " left join fetch oneChat.groupData "
                + "where oneChat.dmlStatus != :dmlStatusValue"
                + " AND group_id = :groupIdValue" + " AND reference_id = 0"
                + " AND root_chat_id = oneChat.chatId";