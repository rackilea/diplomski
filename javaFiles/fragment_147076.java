public class Test{
  public native String ping();
  public static void main(String[] args){
    System.load("/path/to/dll");
    System.out.println("Java is running.");
    Test t = new Test();
    System.out.println("Trying to catch C# " + r.ping());
  }
}