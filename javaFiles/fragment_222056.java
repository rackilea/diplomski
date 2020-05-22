// File Handler.scala
trait Handler { def getHandlers: List[String] }

// File MyPlugin.scala
class MyPlugin extends Handler { def getHandlers = List("salmon", "cod") }

// File Interop.java
public class Interop {
  public static void main(String[] args) {
    try {
      Class classToLoad = Class.forName("MyPlugin");
      Handler handler = (Handler)classToLoad.newInstance();
      System.out.println("Class loader = "+handler.getClass().getClassLoader());
      System.out.println(handler.getHandlers());
    }
    catch (Exception e) { System.out.println("Uh-oh: "+e); }
  }
}