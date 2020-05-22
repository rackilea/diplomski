public static void print(Object s) {
  System.out.println(s.toString());
}

public static <T> void printArray(T[] arr) {
  for (T t : arr) {
    print(t);
  }
}