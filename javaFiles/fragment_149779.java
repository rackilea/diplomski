import java.util.ArrayList;

public class QueryParameters implements Cloneable {
  @Override
  public String toString() {
    return "QueryParameters [action_types=" + action_types + ", otherData="
        + otherData + "]";
  }

  protected ArrayList<String> action_types = new ArrayList<String>();
  protected String otherData;

  @Override
  public QueryParameters clone() throws CloneNotSupportedException {
    QueryParameters cloned = (QueryParameters) super.clone();
    cloned.action_types = new ArrayList<String>(action_types);
    return cloned;
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    QueryParameters test = new QueryParameters();
    test.otherData = "a field";
    test.action_types.add("xyzzy");
    test.action_types.add("abcde");
    System.out.println("Original: " + test);
    QueryParameters clone = test.clone();
    clone.action_types.add("A new action type");
    System.out.println("Modified clone: " + clone);
    System.out.println("Original after clone modification: " + test);
  }
}