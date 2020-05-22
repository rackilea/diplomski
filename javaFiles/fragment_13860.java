int affected = em.createNativeQuery(
    "INSERT INTO rst_offline_transaction_batch (" +
    "    created_date," +     // ?1
    "    user_id" +           // ?2
    ") VALUES (?1,?2)"
    )
    .setParameter(1, new java.util.Date(), TemporalType.DATE)
    .setParameter(2, user_id)
    .executeUpdate();
// Check affected.