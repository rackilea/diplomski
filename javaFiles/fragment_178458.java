public static class FilterResult {}
public static class WrappedFilterResult<T, FR extends FilterResult> extends FilterResult {}
public interface ACComparator<FR extends FilterResult> {}

public static <FR extends FilterResult, T>
  void filter1(ACComparator<? super WrappedFilterResult<? super T, ? super FR>> comparator) {
    // both compile fine with normal Java compiler
    // but error with Eclipse JDT compiler (I'm using Eclipse 4.9.0)
    filter1(comparator);
    filter2(comparator);
}

public static <FR extends FilterResult, T>
  void filter2(ACComparator<? super WrappedFilterResult<? super T, ? super FR>> comparator) {
}