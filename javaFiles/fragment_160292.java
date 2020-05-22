private <CT> CT doCallBatchTasks(DatabaseConnection connection, boolean saved,
        Callable<CT> callable) throws SQLException {
    if (databaseType.isBatchUseTransaction()) {
        return TransactionManager.callInTransaction(connection, saved, databaseType,
            callable);
    }
    ...