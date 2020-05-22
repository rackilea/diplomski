Number transactionId = (Number) session
   .createSQLQuery(
            "SELECT trx_id " +
            "FROM information_schema.innodb_trx " +
            "WHERE trx_mysql_thread_id = CONNECTION_ID()")
   .uniqueResult();