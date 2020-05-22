public void doPost(HttpServletRequest request, HttpServletResponse 
        response) throws IOException, ServletException  {

 ...//check that the request is correct
 String query = request.getParameter("sqlQuery");//name of textarea
 try{
 Connection conn = getConnection();//Search SO for how to get a connection 
 PreparedStatement stmt = conn.prepareStatement(query);
//if your query has any arguments(?) (e.g select * from tbl where id=?),  then you should set them too
 //stmt.setInt(1, 1000);
ResultSet rs = stmt.executeQuery();
while(rs.next()){

//get database dana here
int someIntVal = rs.getInt("intColumn");
String someStr = rs.getString("someStringColumn");
}catch(SQLException e){
//handle exception
}
}