//this should be in a different class. So it's easier to maintain and can be used elsewhere. It's bad practice to have database logic in your servlet. Because what if you want to use this in a different servlet or another part of your application? (you don't want to copy and pasta it everywhere do you?)

public static boolean validate(String email, String password){          
     boolean status = false;  
    PreparedStatement pst = null;  
    ResultSet rs = null;  
     //if you put your getConnection method as a try condition, it will automagically close the connection for you. 
    try(Connection conn= ConnectionConfiguration.getConnection()){

        pst = conn.prepareStatement("select * from users where email=? and password=?;");  
        pst.setString(1, email);   //1 here corresponds to the first '?' in preparedStatement
        pst.setString(2, password);  //2 corresponds to the second '?'
        rs = pst.executeQuery();  

        status = rs.next();  //if there are any results, then status is true. 
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return status;  
}