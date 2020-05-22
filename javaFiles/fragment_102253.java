public abstract class Record {
  protected abstract String getTableName();
  protected abstract String[] getTableColumns();

  private void save(){
    //save data based on getTableName() and getTableColumns();
  }
}

public class Person extends Record {
  protected String getTableName() {
    return "People";
  }
  protected String[] getTableColumns() {
    return new String[] { "_id", "name" };
  }
}