import java.util.ArrayList;

public class Run implements Interface {
  public static void main(String[] argv) {
    ArrayList<Interface> things = new ArrayList<Interface>();
    // Implements the interface directly
    things.add(new Run()); 
    // NativeInterface implements interface also
    things.add(test.find_interface("My lookup key")); 

    // Will get wrapped in the proxy 
    test.bar(things.get(0));

    // Won't get wrapped because of the instanceOf test
    test.bar(things.get(1));
  }

  public String foo() {
    return "Hello from Java!";
  }
}