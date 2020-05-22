public Tree() {
  this(Comparator.naturalOrder());
}

public Tree(Comparator<? super T> comparator) {
  this.comparator = comparator; // store in a field
}