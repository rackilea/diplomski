for (String sql : SQLscript) { 
    boolean error = false;
    try {
        int result = statement.executeUpdate(sql);
    } catch (SQLException e) {
        error = true;
        e.printStackTrace();
    }
    if (error) {
        // Do something special
    }

}