@Query("SELECT c, (SELECT COUNT(m) FROM Message m WHERE m.conversation = c AND :participant MEMBER OF m.newFor) " +
        "FROM Conversation c " +
        "WHERE :participant MEMBER OF c.participants " +
        "GROUP BY c, c.lastMessage.createdDate " +
        "ORDER BY c.lastMessage.createdDate DESC")
List<Object[]> findConversationsPerParticipant(Participant participant, Pageable pageable);