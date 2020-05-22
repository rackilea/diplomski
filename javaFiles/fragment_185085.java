public class myName {
  public static String name;
  public void setName(String newName) {
    name = newName;
  }
  public String getName() {
    return name;
  }
  public static void main(Strings args[]) {
     myName first = new myName();
     myName second = new myName();
     first.setName("hello");
     System.out.println(second.getName());  //prints hello
  }
}