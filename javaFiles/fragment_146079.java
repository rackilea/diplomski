public class Worker extends Person {
  public Worker(boolean parent) {
   super(parent);
  }
} 

public class Person {
  private boolean parent;

  public Person(boolean parent) {
      this.parent = parent;
  }
}