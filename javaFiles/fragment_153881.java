try(Connection conn = DAOUtil.getConnection();
    PreparedStatement ps = conn.prepareStatement(addSubscriptionSql);
    AutoCloseable finish = conn::rollback) {

    conn.setAutoCommit(false);
    //do work
    conn.commit();
}