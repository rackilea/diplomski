public void initialize(URL arg0, ResourceBundle arg1) {     
}

public void setRegion(String region) {
    regi=region;
    try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bimbima","root","");  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("SELECT * FROM  `file` WHERE Region = '"+regi+"'");  
        while(rs.next())  {
        filename=rs.getString("filename");
        nameofSup=rs.getString("Name of Supervisor");
        System.out.println(filename);
        }
        con.close();  
    } catch(Exception e) { 
        e.printStackTrace();
    }  
}