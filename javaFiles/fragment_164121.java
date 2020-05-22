Number transactionId = (Number) session
   .createSQLQuery(
            "SELECT GTID " +
            "FROM events_transactions_current e " +
            "JOIN performance_schema.threads t ON e.THREAD_ID = t.THREAD_ID " +
            "WHERE t.PROCESSLIST_ID = CONNECTION_ID()")
   .uniqueResult();