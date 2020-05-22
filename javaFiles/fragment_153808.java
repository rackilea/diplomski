PreparedStatement ps = null;
InputStream is = null;
try {

    con = // get your database connection
    ps = con.prepareCall("insert into IMAGES values (?)");
    is = new FileInputStream(new File("file path"));
    ps.setBinaryStream(1, is);
    int count = ps.executeUpdate();

} catch (ClassNotFoundException e) {        
    e.printStackTrace();
} catch (SQLException e) {           
    e.printStackTrace();
} catch (FileNotFoundException e) {  
    e.printStackTrace();
} finally{
    try{
        if(is != null) is.close();
        if(ps != null) ps.close();
        if(con != null) con.close();
    } catch(Exception ex){}
}