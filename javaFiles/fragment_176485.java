import java.util.*;

class Main {
  public static void main(String[] args) {
    String strExample = "{'27': [], '10864': [u'8344', u'7769', u'7207', u'3735']}";

    // Initialize
    List<String> keys = new ArrayList<String>();
    List<String> values = new  ArrayList<String>();

    // Hacky regex parsing -- happy now???
    for (String component : strExample.replace("{","").split("][,}]")) {
      String kv[] = component.split(": ");
      keys.add(kv[0]);
      values.add(kv[1] + "]");
    }

    // Print
    System.out.println("Keys: ");
    for (String key : keys) {
      System.out.println(key);
    }
    System.out.println("\nValues: ");
    for (String value : values) {
      System.out.println(value);
    }

  }

}