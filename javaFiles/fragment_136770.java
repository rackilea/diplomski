public static void main(String args[]) {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  map.put(1, 3);
  map.put(3, 1);
  map.put(5, 6);
  map.put(2, 10);
  // Prints: {3=1, 1=3, 5=6, 2=10}
  System.out.println(entriesSortedByValues(map));
}