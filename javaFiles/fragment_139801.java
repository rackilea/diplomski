public static String removeFruit(String fruits, int n)
{
  String[] a = fruits.split(",");
  return Stream.concat(Arrays.stream(a, 0, n), Arrays.stream(a, n + 1, a.length))
      .collect(Collectors.joining(","));
}