import java.util.Map;

public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");

    Map<String,String> m = new MapType();
    m.put("key1", "value1");
    System.out.println(m);
    m = test.foo(m);
    System.out.println(m);
  }
}