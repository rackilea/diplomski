try(Connection conn = DAOUtil.getConnection();
    PreparedStatement ps = conn.prepareStatement(addSubscriptionSql);
    SQLCloseable finish = () -> { if(!conn.getAutoCommit()) conn.rollback(); }) {

    conn.setAutoCommit(false);
    //do work
    conn.commit();
    conn.setAutoCommit(true);
}