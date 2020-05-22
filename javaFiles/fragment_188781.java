Connection conn = ...

boolean error = false;
try {
    for (String sql : SQLscript) { 
        int result = statement.executeUpdate(sql);
    }
    conn.commit();
} catch (SQLException e) {
    e.printStackTrace();
    conn.rollback();
    error = true;
}

if (error) {
    // Do something special
}