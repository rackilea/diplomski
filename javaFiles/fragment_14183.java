public class InterfaceDemo
{
  public static void main(String... args)
  {
    XYZ.executeStatic("Hello");

    XYZ object = new Implementer();
    object.executeInstance("Message");
  }
}

interface XYZ
{
  static void executeStatic(String message)
  {
    System.out.println("Static: " + message);
  }

  default void executeInstance(String message)
  {
    System.out.println("Instance: " + message);
  }
}

class Implementer implements XYZ {}