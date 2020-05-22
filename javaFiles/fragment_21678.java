String url, username, pass;
url = "your-connection-url";
username = "db-username";
pass = "db-password";
Connection outerConnection = null;

try (Connection innerConnection = DriverManager.getConnection(url, username, pass);
     PreparedStatement psmt = innerConnection.prepareStatement("SELECT 1");
     ResultSet rs = psmt.executeQuery();)
{
   while (rs.next()) {
       System.out.println(rs.getString(1));
   }

   outerConnection = innerConnection;

   // after the try catch, innerConnection won't exist anymore
   // (the scope ends, the compiler compains if you access it outside the block!)
} catch (SQLException e) 
{
   e.printStackTrace();
}

if (outerConnection != null) {
    try {
       System.out.println("Is closed? " + outerConnection.isClosed());
    }
    catch (SQLException e) {
       e.printStackTrace();
    }
}
else {
    System.out.println("Is null");
}