public interface Frobnicator<E extends Enum<E>> {
  void frobnicate(E value);
}


enum Bar {
  X, Y;
}

class BarFrobnicator implements Frobnicator<Bar> {
  @Override
  public void frobnicate(Bar value) {
    // do stuff
  }
}