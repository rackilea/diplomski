public class Super {
  public Super(int i) {
  }
}

public class Sub extends Super {
  public Sub() {
    super(0); // <-- explicit constructor call
  }
}