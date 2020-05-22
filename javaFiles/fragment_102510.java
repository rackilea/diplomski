new Comparator<Component>() {
  @Override public int compare(Component left, Component right) {
    int cmp = Integer.compare(left.weight, right.weight);
    if (cmp == 0) {
      cmp = left.color.compareTo(right.color);
    }
    return cmp;
  }
};