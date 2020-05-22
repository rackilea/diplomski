public List<Predicate<T> verify(Map<String, Predicate<T>> predicates) {
  List<Predicate<T>> failed = new ArrayList<>();
  for( String name : predicates.keySet() ){
    System.out.println("Testing "+name+" on "+t);
    // test predicates.get(name), add failed test to failed list.
  }
  return failed ;
}