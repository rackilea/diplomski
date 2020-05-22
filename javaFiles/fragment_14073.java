public static void main(String[] args) {
    int[] intArr = new int[] { 0, 1, 2 };
    Integer[] boxed = toBoxedArray(intArr);
    System.out.println(boxed); // [Ljava.lang.Integer;34340fab
    System.out.println(toBoxedArray(boxed)); // null
    System.out.println(castArrayToList(intArr)); // [0, 1, 2]
    System.out.println(castArrayToList(boxed)); // null
  }