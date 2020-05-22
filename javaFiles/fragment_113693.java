public static boolean doUpdate(String statement) {
    boolean result = false;
    openConnection();
    try {
        stmt = conn.createStatement();
        result = stmt.executeUpdate(statement) > 0;
    } catch (SQLException ex) {
        System.out.println(DBhandler.class.getName()+"\n"+ex);
    } finally {
        closeConnection();
    }

    return result;
}