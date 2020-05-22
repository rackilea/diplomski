conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
for (int i = 0; i < jsrequestarray.size(); i++) {
    try {
        //current code...
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (prpd_stmt != null)
                prpd_stmt.close();
        } catch (SQLException e1) {
        }
    }
}
try {
    if (conn != null)
        conn.close();
} catch (SQLException e1) {
}