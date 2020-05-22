public class CoolDude {
  public static void main(String[] args) {
    final int min = 100;
    final int max = 500;
    for (int i5 = nextMultiple(min, 5), i11 = nextMultiple(min, 11); i5 <= max || i11 <= max; ) {
      if (i5 < i11) {
        System.out.printf("Cool - %d%n", i5);
        i5 += 5;
      } else if (i11 < i5) {
        System.out.printf("Dude - %d%n", i11);
        i11 += 11;
      } else { // i5 == i11
        System.out.printf("Cool Dude - %d%n", i5);
        i5 += 5;
        i11 += 11;
      }
    }
  }
  static int nextMultiple(int number, int divisor) {
    int roundToLower = (number - 1) / divisor * divisor;
    return roundToLower + divisor;
  }
}