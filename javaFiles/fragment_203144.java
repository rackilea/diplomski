/** Contains a Comparator<String> that also implements the given type T. */
class StringComparatorHolder<T, C extends T & Comparator<String>> {
  private final C comparator;
  // ...
}

void foo(StringComparatorHolder<Comparator<Integer>, ?> holder) { ... }