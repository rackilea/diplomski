Collections.sort(list, new Comparator<Map<String, String>>() {
   @Override public int compare(Map<String, String> a, Map<String, String> b) {
      return Integer.compare(
         Integer.parseInt(a.get("Score")),
         Integer.parseInt(b.get("Score")));
   }
});