PreparedStatement ps = con.prepareStatement("select * from MyImageTable");  
   ResultSet rs = ps.executeQuery();  

   if(rs.next()){  

   Blob blob = rs.getBlob(2); //Here 2 is second column data  
   byte b[] = blob.getBytes(1,(int)b.length());  //Here 1 represent first image  

   FileOutputStream output = new FileOutputStream("e:\\some_pic.jpg");  //path goes here
   output.write(b);  

   output.close();