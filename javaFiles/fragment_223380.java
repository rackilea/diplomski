public class MyTreeSet<T> extends TreeSet<T> {
  public MyTreeSet(Comparator<? super T> cmp, Collection<? extends T> coll) {
    super(cmp);
    addAll(coll);
  }
}