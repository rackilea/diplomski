PreparedStatement ps = nulll;
try {
    ps = connection.prepareStatement("INSERT INTO testtable1 (key1a, key1b , encoded1a,encoded1b) VALUES (? ,? ,?, ?)");
    for (int i = 1; i <= k.length; i++) {
        ps.setString(i, "" + k[i]);
    }

    ps.executeUpdate();
} catch (SQLException) {
    //Log exception
} finally {
    if (ps != null) {
        try {
            ps.close();
            ps = null;
        } catch (SQLException e) {}
    }
}