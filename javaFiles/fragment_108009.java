PreparedStatement pstmt = null;
Connection conn = null;

try{
     //if you have a method that creates a connection for you.
     conn = getConnection();
     pstmt = conn.prepareStatement("INSERT INTO tops(id, title, elements, size, entity, timeStamp) VALUES(?,?,?,?,?,?)");
     pstmt.setInt(1,item.getID());

     //Assuming that title is a String data type
     pstmt.setString(2,item.getTitle());
     pstmt.setString(3,this.elements);
     pstmt.setDouble(4,item.getSize()); // <--- JDBC will make sure this works

     //assuming Entity data type is String
     pstmt.setString(5,item.getEntity());

     //if your timestamp's string format is 
     //well formed, you may insert as a string.
     pstmt.setString(6,timestamp.toString());
     pstmt.executeUpdate();
}catch(Exception e){
     e.printStackTrace();
}finally{  
     try{
         pstmt.close();
     }catch(Exception e){}

     try{
         conn.close();
     }catch(Exception e){}
 }