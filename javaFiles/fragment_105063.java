public interface MyInterface {
  void setNumber(int num); // public is implicit in interfaces
  int getNumber();         // obviously
}

public class MyClass implements MyInterface {
  private int number = 0;

  public void setNumber(int num) { this.number = num; }
  public int getNumber() { return this.number; }
}