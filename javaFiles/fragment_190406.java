public <T> List<T> mergeList(List<T> first, List<T> second) {

  return (first != null && second != null && first.addAll(second)) 
    ? first 
    : Collections.<T>emptyList();

}