import java.util.AbstractList;

public class test {
  public static void main(String[] argv) {
    Vector v = num.testVec();
    AbstractList<Double> l = v;
    for (Double d: l) {
      System.out.println(d);
    }
    Matrix m = num.testMat();
    m.get(5).set(5, new Double(5.0));
    for (Vector col: m) {
      for (Double d: col) {
        System.out.print(d + " ");
      }
      System.out.println();
    }
  }
}