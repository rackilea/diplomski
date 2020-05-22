public class Person {

  MaritalState maritalState;
  Person mate;
  String name;

  Person(String name1) {
    maritalState = new MaritalState();
    mate = null;
    name = name1;
  }

  void GetMarried(Person mate) {
    maritalState.marry(this, mate);
  }

  void GetDivorced(Person mate) {
    maritalState.divorce(this, mate);
  }

  void Died() {
    maritalState.die(this);
  }

  void PrintMaritalStatus() {
    System.out.println(this.name + " maritalState status is " + this.maritalState.get());
  }

  public boolean isMarried() {
    return maritalState.isMarried(maritalState);
  }

  public boolean isSingle() {
    return maritalState.isSingle(maritalState);
  }

  public boolean isWidow() {
    return maritalState.isWidow(maritalState);
  }
}