public class H2TestFunctionUtility {
  public static ResultSet array() {
    // build your mocked result here
    String[] columnNames = new String[] {"column", "names", "here"};
    Object[][] rowValues = new Object[][] { {"values"}, {"go"},  {"here"}}; 
    return MockResultSet.create(columnNames, rowValues); //
  }
}