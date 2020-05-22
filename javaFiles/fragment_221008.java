connection.setAutoCommit(false);
try {
    ...
    stmt1.execute();
    ...
    stmt2.execute();
    connection.commit();
} catch (Exception ex) {
    connection.rollback();
}