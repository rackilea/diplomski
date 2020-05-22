Collections.sort(results, new Comparator<String>() {
   public int compare(String a, String b) {
      int valueA = Integer.parseInt(a);
      int valueB = Integer.parseInt(b);
      return valueA - valueB;
   }
});