try (Scanner sc = new Scanner(System.in)) {
  String next = sc.next(); // again, without hasNext().
}
try (Scanner sc = new Scanner(System.in)) {
  String next = sc.next(); // fail NoSuchElementException (stream is closed).
}