public class SapExample
{

  public static void main(String[] args)
  {
    // read SAP data..

    // get table
    List<Map<String, Object>> objects = getTable("ET_WIDGET");

    for (Map<String, Object> entry : objects) {
        Widget obj = getObject(entry , Widget.class);
    }
  }

  private static List<Map<String, Object>> getTable(String string)
  {
    return Collections.emptyList();
  }
}