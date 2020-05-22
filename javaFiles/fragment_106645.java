public static void main(String[] args) {
  String[] A = { "1", "2", "3", "4", "5" };
  String[] B = { "1", "2" };
  compareStringArray(A, B, true);
}

public static void printArrayListOfStringAsCSV(
    List<String> al) {
  for (int i = 0; i < al.size(); i++) {
    if (i != 0) {
      System.out.print(", ");
    }
    System.out.print(al.get(i));
  }
  System.out.println();
}