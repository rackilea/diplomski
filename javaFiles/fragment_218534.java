try{
   Class.forName("com.mysql.jdbc.Driver");
   Connection myConn = DriverManager.getConnection("JDBC:mysql://localhost:3306/cupcakes", "kristoffer", "******");
   Statement myStmt = myConn.createStatement();

   ResultSet myRs = myStmt.executeQuery("Select * from cupcakes");
   while(myRs.next()){
       System.out.println("Cupcakes: " + myRs.getString("name"));