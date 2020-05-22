public class ClassB {
  private ClassB() {}

  private void loadStuff(boolean initialize) throws ClassNotFoundException {
    if (initialize) {
      Class.forName("ClassA");
    } else {
      this.getClass().getClassLoader().loadClass("ClassA");
    }
  }

  public static void main(String[] args) throws ClassNotFoundException {
    ClassB b = new ClassB();
    b.loadStuff(true); // Try also false
  }
}