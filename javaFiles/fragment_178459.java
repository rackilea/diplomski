public static
< FR extends FilterResult, T,
  A extends ACComparator<? super WrappedFilterResult<? super T, ? super FR>> // <-- here
>
void filterSuccess(A comparator) {
    // success!
    filter1(comparator);
    filter2(comparator);
}