public class LoudPerson extends Person {

  void sayName() {
    System.out.println("I yell my name!!");
  }

void givesBusinessCard() throws UnsupportedOperationException {
  throw new UnsupportedOperationException("not needed here");
}
}