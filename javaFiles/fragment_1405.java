@Override public UnmodifiableIterator<C> iterator() {
    return new AbstractLinkedIterator<C>(first()) {
      final C last = last();

      @Override
      protected C computeNext(C previous) {
        return equalsOrThrow(previous, last) ? null : domain.next(previous);
      }
    };
  }

  private static boolean equalsOrThrow(Comparable<?> left,
      @Nullable Comparable<?> right) {
    return right != null && compareOrThrow(left, right) == 0;
  }

  private static int compareOrThrow(Comparable left, Comparable right) {
    return left.compareTo(right);
  }