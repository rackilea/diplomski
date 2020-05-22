final boolean oldAutoCommit = stat.getConnection().getAutoCommit();
stat.getConnection().setAutoCommit(false);

try {
    // Your update and insert code here
} catch(Exception e) {
    stat.getConnection().rollback();
} finally {
    stat.getConnection().commit();
    stat.getConnection().setAutoCommit(oldAutoCommit);
}