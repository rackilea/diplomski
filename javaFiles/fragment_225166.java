for(Collection<String> col : multimap.asMap().values()) {
  for(String pair : genPairs(col)) {
    System.out.println(pair);
  }
  System.out.println();
}