Connection connection = null;

try {
   connection = ConnectionFactory.create();

   [...]

   // More code which probably causes an exception

} catch(Exception e) {
   // Handle the exception
} finally {
    if(connection != null) {
      // Cleanup and close resources later
      connection.close()
    }
}