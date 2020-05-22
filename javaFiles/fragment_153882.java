try(Connection conn = DAOUtil.getConnection();
    PreparedStatement ps = conn.prepareStatement(addSubscriptionSql);
    SQLCloseable finish = conn::rollback) {

    conn.setAutoCommit(false);
    //do work
    conn.commit();
}