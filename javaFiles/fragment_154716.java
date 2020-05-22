public static interface IdEntity extends Comparable<IdEntity> {
  int getId();
  @Override default int compareTo(IdEntity other) {
    return defaultCompare(this, other);
  }
  static int defaultCompare(IdEntity first, IdEntity second) {
    return first.getId() - second.getId();
  }
}