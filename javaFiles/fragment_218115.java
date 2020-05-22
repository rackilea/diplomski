/**
   * Returns an immutable set containing the given elements, in order. Repeated
   * occurrences of an element (according to {@link Object#equals}) after the
   * first are ignored. This method iterates over {@code elements} at most once.
   *
   * <p>Note that if {@code s} is a {@code Set<String>}, then {@code
   * ImmutableSet.copyOf(s)} returns an {@code ImmutableSet<String>} containing
   * each of the strings in {@code s}, while {@code ImmutableSet.of(s)} returns
   * a {@code ImmutableSet<Set<String>>} containing one element (the given set
   * itself).
   *
   * <p>Despite the method name, this method attempts to avoid actually copying
   * the data when it is safe to do so. The exact circumstances under which a
   * copy will or will not be performed are undocumented and subject to change.
   *
   * @throws NullPointerException if any of {@code elements} is null
   */
  public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> elements) {
    return (elements instanceof Collection)
        ? copyOf(Collections2.cast(elements))
        : copyOf(elements.iterator());
  }