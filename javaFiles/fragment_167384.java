StringBuilder jpql = new StringBuilder()
jpql.append(" SELECT n FROM Notification n ");
jpql.append("   WHERE n.recipientEmail = :recipientEmail ");
jpql.append("   AND n.isUnread = :isUnread ");
jpql.append("   AND n.growToshow = :growToshow ");
jpql.append(" ORDER BY n.createdTime DESC ");

TypedQuery<Notification> query = em.createQuery(jpql.toString(), Notification.class);

query.setParameter("recipientEmail", user.getEmail());
query.setParameter("isUnread", 1);
query.setParameter("growToshow", 1);