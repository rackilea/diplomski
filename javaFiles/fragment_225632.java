FileInputStream fis;
  try {
       // Load JDBC driver "com.mysql.jdbc.Driver"
       Class.forName("oracle.jdbc.driver.OracleDriver");

      /* Create a connection by using getConnection() method that takes
         parameters of string type connection url, user name and password to
         connect to database. */
         String connectionUrl = "your connection url";
         String userName = "connecting database username";
         String password = "corresponding password";
         connection = DriverManager.getConnection(connectionUrl ,userName , password);
         // create a file object for image by specifying full path of image as parameter.
         File image = new File("C:/image.jpg");
         /* prepareStatement() is used for create statement object that is
            used for sending sql statements to the specified database. */
         psmnt = connection.prepareStatement("insert into save_image(name, city, image) values(?,?,?)");
         psmnt.setString(1,"name");
         psmnt.setString(2,"city");
         fis = new FileInputStream(image);
         psmnt.setBinaryStream(3, (InputStream)fis, (int)(image.length()));
         /* executeUpdate() method execute specified sql query. Here this query
            insert data and image from specified address. */
         int s = psmnt.executeUpdate();
         if(s>0) {
                    System.out.println("Uploaded successfully !");
         } else {
                    System.out.println("unsucessfull to upload image.");
         }
   } catch (Exception e){
       //log useful information
   }
   finally{
        if (fis != null) {
        fis.close();
        }
        if(psmnt != null){
           psmnt.close();
        }
        if (connection!= null && !connection.isClosed()) {
           connection.close();
        }
   }