public static void setValue(String user, Integer id){
    Connection connection = null;
    try {
        try {
            connection = DataSource.getInstance().getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ttl++;
        PreparedStatement ps = connection.prepareStatement("REPLACE INTO " + "accounts"+ " (user,id) VALUES(?,?)");
        ps.setString(1, user);
        ps.setInt(2, id);
        ps.executeUpdate();
                    ps.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        if (connection != null) connection.close();
    }    
    return;
}