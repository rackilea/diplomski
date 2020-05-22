Session s = sessionfactory.openSession();
Connection conn = null;
try {
    conn = s.connection();
    // Your data manipulation here
    conn.commit();
} catch (Exception e) {
    if (conn != null) { 
        try {
            conn.rollback();
        catch (IOExceptin) {}
    }
} finally {
    s.close();
}