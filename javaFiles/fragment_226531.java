class SchwartzianKV<E, SORTKEY implements Comparable<SORTKEY> > 
      implements Comparable<SchwartzianKV<E, SORTKEY>> {

    public final E e;
    public final SORTKEY sortkey;

    SchwartzianKV(E e, SORTKEY sortkey){
        this.e = e;
        this.sortkey = sortkey;
    }

    public static <E, SORTKEY implements Comparable<SORTKEY>> 
    Function<E, SchwartzianKV<E, SORTKEY>> transformer( Function<E, SORTKEY> fn ) {
       return new Function<E, SchwartzianKV<E,SORTKEY>>() {
           @Override SchwartzianKV<E,SORTKEY> apply(E e) {
               return new SchwartzianKV<>(e, fn.apply(e));
           } 
       }
    }

    public int compare(With<E> other) {
       return sortkey.compare(other.sortkey);
    }
}