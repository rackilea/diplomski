try {
    //you state that the transaction needs a commit statement
    conn.setAutoCommit(false);
    //perform your DML statements
    //...
    //explicitly state you're committing the transaction
    conn.commit();
} catch (Exception e) {
    //rollback the transaction
    conn.rollback();
    //handle the exception...
    //Note: always retrieve the stacktrace
    //it would be better to use a log or another way to archive it
    //this is a pretty basic example
    e.printStacktrace(),
}