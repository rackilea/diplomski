public void newClient(String name, String address, String phoneNumber){
    PreparedStatement ps = null;
    try {
        createConnection();
        String insert="INSERT INTO CUSTOMER(ID,CNAME,ADDRESS, PHONENUMBER) VALUES(?,?,?,?)";
        ps=conn.prepareStatement(insert);
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setString(3, phoneNumber);
        ps.executeUpdate();
    } catch (Exception ex)  {
        ex.printStackTrace();
    } finally  {
        ps.close();
        closeConnection();
    }
}