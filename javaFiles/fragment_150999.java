public static void main (String[] args) {
  String commaSeparated = "0,1,2,3,4,5,6,7,8,9";
  int[] arguments =
    Stream
      .of(commaSeparated.split(","))
      .mapToInt(Integer::parseInt)
      .toArray();
  pages(arguments);
}

public static void pages(int... numbers) {
  System.out.println("numbers: " + Arrays.toString(numbers));
}