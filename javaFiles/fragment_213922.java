public void insertImage(String CUST_ID, String d) throws SQLException {
    try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectionURL);

            } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
    File image = new File(d);      
    FileInputStream fis = new FileInputStream(image);
    stm = con.prepareStatement("insert into customer (PHOTO ) values(?)); //it gives errorr here
    stmt.setBinaryStream(5, fis, (int) image.length());
    //stm.setObject(5,saveImage);
    //stm.executeUpdate();
    stm.execute();
}