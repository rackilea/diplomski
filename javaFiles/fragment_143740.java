public void bark() {
   BarkListeners.callBack(this);
}

public class BarkListeners {
  private static final List<Dog> barkers = new ArrayList<Dog>();

  public static void callBack(Dog dog) {
    barkers.add(dog);
  }
}