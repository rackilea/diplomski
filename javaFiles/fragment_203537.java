public class Person implements AgingObject {
  private int age;  
  private AgingBehavior agingBehavior;

  void makeOlder() {
    agingBehavior.makeOlder(this);
  }
  //(...)
}

public class Cat implements AgingObject {
  private int age;
  private AgingBehavior agingBehavior;

  void makeOlder() {
    agingBehavior.makeOlder(this);
  }
  //(...)
}

public class AgingBehavior {
  void makeOlder(AgingObject agingObject) {
    agingObject.setAge(agingObject.getAge() + 2);
  }
}

public interface AgingObject {
    int getAge();
    void setAge(int age);
}