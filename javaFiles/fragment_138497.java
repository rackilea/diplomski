public void newClient(Integer id, String name, String address, String phoneNumber){
    PreparedStatement ps = null;
    try {
        createConnection();
        String insert="INSERT INTO CUSTOMER(CNAME,ADDRESS, PHONENUMBER) VALUES(?,?,?)";
        ps=conn.prepareStatement(insert);
        ps.setInt(1, id)
        ps.setString(2, name);
        ps.setString(3, address);
        ps.setString(4, phoneNumber);
        ps.executeUpdate();
    } catch (Exception ex)  {
        ex.printStackTrace();
    } finally  {
        ps.close();
        closeConnection();
    }
}