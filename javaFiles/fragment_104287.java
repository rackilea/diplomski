public static void main(String args[]) {
  long[] numbers = {0, 5, 999, 1_000, -5_821, 10_500, -101_800, 2_000_000, -7_800_000, 92_150_000, 123_200_000, 9_999_999, 999_999_999_999_999_999L, 1_230_000_000_000_000L, Long.MIN_VALUE, Long.MAX_VALUE};
  String[] expected = {"0", "5", "999", "1k", "-5.8k", "10k", "-101k", "2M", "-7.8M", "92M", "123M", "9.9M", "999P", "1.2P", "-9.2E", "9.2E"};
  for (int i = 0; i < numbers.length; i++) {
    long n = numbers[i];
    String formatted = format(n);
    System.out.println(n + " => " + formatted);
    if (!formatted.equals(expected[i])) throw new AssertionError("Expected: " + expected[i] + " but found: " + formatted);
  }
}