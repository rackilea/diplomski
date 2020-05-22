class abc {
  void show() {
    System.out.println("First Class");
  }
}

// def extends from abc
class def extends abc {
  // show() method was overridden here
  void show() {
    System.out.println("Second Class");
  }
}

class demo {
  public static void main(String args[]) {
    // Use the reference type abc, object of type abc
    abc a1 = new abc();
    // Use the reference type abc, object of type def
    abc a2 = new def();
    // invokes the show() method of abc as the object is of abc
    a1.show();
    // invokes the show() method of def as the object is of def
    a2.show();
  }
}