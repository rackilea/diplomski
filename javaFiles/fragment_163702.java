public class Main {
  public static void main(String[] args) {
      SuperClass s = new SuperClass();
      ChildClass c = new ChildClass();
      s.superMethod();
      c.superMethod();
  }
}

class SuperClass {
    private static final String a = "Super";

    public void superMethod(){
        System.out.println("SuperMethod: " + getA());
    }

    public String getA() {
      return a;
    }

}

class ChildClass extends SuperClass {

    private static final String a = "Child";

    @Override
    public String getA() {
      return a;
    }
}