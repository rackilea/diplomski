public class BinaryPrinter  {
  static void printAllBinary(String s, int n) {
    if (n == 0) System.out.println(s);
    else {
      printAllBinary(s + '0', n - 1);
      printAllBinary(s + '1', n - 1);
    }
  }

  public static void main(String [] args) {
    printAllBinary("", 4);
  }
}