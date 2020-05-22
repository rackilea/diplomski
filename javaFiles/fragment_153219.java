public class YourClass
{
  private static final int MAX_ID = 8; // or however you want to set the size
  private String[] title; // [] after the type is easier to read, lower case variables
  private Connection conn; // I'm assuming the class will be provided a DB connection
  // Note the Statement and ResultSet objects are not defined in the class, to
  // minimize their scope.

  public void queryInfo() // name suggests a query (potentially expensive) will be run
  {
    title = new String[MAX_ID]; // **initialize title**
    // We use a try-with-resources block to ensure the statement is safely closed
    // even better would be to use a PreparedStatement here
    try(Statement st = conn.statement())
    {
      // You're executing 8 separate queries here, where one will do
      String query = "SELECT * FROM students WHERE ID >= 1 AND ID <= "+MAX_ID;
      // Again, we need to close the result set when we're done
      try(ResultSet rs = st.executeQuery(query))
      {
        int i = 0;
        while (rs.next())
        {   
          title[i++] = rs.getString("StudentName");
        }
      } // close our ResultSet
    } // close our Statement
  }

  // provide a separate getter method, rather than making the array public
  public String[] getTitles()
  {
    return title;
  }
}