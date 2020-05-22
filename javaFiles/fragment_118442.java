abstract class LowLevelPQ<T> {

  interface DataHandler<R, T> {
    R handle(byte[] source, int startLoc);
  }

  LowLevelPQ(int entryByteSize) { ... }
  abstract encode(T element, byte[] target, int startLoc);
  abstract T decode(byte[] source, int startLoc);
  abstract int compare(byte[] data, int startLoc1, int startLoc2);

  abstract <R> R peek(DataHandler<R, T> handler) { ... }
  abstract <R> R pop(DataHandler<R, T> handler) { ... }
}

class WeightedPoint {
  WeightedPoint(int weight, double x, double y) { ... }
  double weight() { ... }
  double x() { ... }
  ...
}

class WeightedPointPQ extends LowLevelPQ<WeightedPoint> {
  WeightedPointPQ() {
    super(4 + 8 + 8); // int,double,double
  }

  int compare(byte[] data, int startLoc1, int startLoc2) {
    // relies on Java's big endian-ness
    for (int i = 0; i < 4; ++i) {
      int v1 = 0xFF & (int) data[startLoc1];
      int v2 = 0xFF & (int) data[startLoc2];
      if (v1 < v2) { return -1; }
      if (v1 > v2) { return  1; }
    }
    return 0;
  }

  ...
}