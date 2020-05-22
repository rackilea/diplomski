public class LongMsb {
  public static void main(String[] args) {
    long value = 785537;
    System.out.printf("%016x\n", value);
    value |= Long.MIN_VALUE;
    System.out.printf("%016x\n", value);
  }
}