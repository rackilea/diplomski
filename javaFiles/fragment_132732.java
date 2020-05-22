List<Person> filteredList = new ArrayList<Person>(allPersons);
CollectionUtils.filter( filteredList, new Predicate() {
  boolean evaluate(Object object) {
    //do whatever you want
  }
});