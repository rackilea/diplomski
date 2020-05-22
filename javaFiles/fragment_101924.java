Blob image = null;
        byte[] imgData = null;
       String id= request.getParameter("id");//here you are getting id 
       int i;
       ResultSet rs =null;

 try {

            //loading drivers for mysql
           Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");


         String sql = "SELECT image FROM tablename where id=?"; //here pass that id in query to get particular image 

           PreparedStatement ps = con.prepareStatement(sql);


               ps.setString(1, id);
              rs = ps.executeQuery();    
 while (rs.next()) {
                  image = rs.getBlob("image");//getting image from database 
                  imgData = image.getBytes(1,(int)image.length()); //extra info about image
                } 

response.setContentType("image/gif");//setting response type



OutputStream o = response.getOutputStream();

o.write(imgData);//sending the image to jsp page 
o.flush();
o.close();


 }
    catch(Exception e)
         {
             e.printStackTrace();

         }