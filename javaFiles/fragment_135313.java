Transaction txn = session.beginTransaction();
Query updateQuery = session.createQuery("UPDATE Post p SET p.title = ?1, p.body = ?2 WHERE p.id = ?3");
updateQuery.setParameter(1, title);
updateQuery.setParameter(2, body);
updateQuery.setParameter(3, id);
updateQuery.executeUpdate();
txn.commit();