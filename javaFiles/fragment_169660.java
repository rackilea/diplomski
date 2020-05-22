static long sum;
public static void main(String[] args) {
  System.out.println("Warming up...");
  for (int i = 0; i < 100_000; i++) test(1);
  System.out.println("Main call");
  test(5_500_000);
  System.out.println("Sum: " + sum);
}

static void test(int size) {
//  for (int i = 0; i < 1; i++)
  {
    long[] a2 = new long[size];
    sum += a2.length;
  }
  long[] a1 = new long[size];
  sum += a1.length;
}