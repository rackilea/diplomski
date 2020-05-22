public static void main(String[] args) {
  // Just an example
  int[] values = new int[5];
  System.out.println(Arrays.toString(values));

  populateArray(values);
  System.out.println(Arrays.toString(values));
}

private static void populateArray(int[] toBePopulated) {
  toBePopulated[0] = 42;
  toBePopulated[1] = 11;
  // Etc. Again, just an example.
}