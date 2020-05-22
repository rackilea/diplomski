new Comparator<Component>() {
  @Override public int compare(Component left, Component right) {
    return ComparisonChain.start()
       .compare(left.weight, right.weight)
       .compare(left.color, right.color)
       .result();
  }
};