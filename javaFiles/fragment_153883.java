boolean[] success = { false };
try(Connection conn = DAOUtil.getConnection();
    PreparedStatement ps = conn.prepareStatement(addSubscriptionSql);
    SQLCloseable finish = () -> { if(!success[0]) conn.rollback(); }) {

    conn.setAutoCommit(false);
    //do work
    conn.commit();
    success[0] = true;
}