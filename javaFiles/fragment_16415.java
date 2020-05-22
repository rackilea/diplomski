static <T extends Comparable<T>> int cp(T a, T b) {
     return
         a==null ?
         (b==null ? 0 : Integer.MIN_VALUE) :
         (b==null ? Integer.MAX_VALUE : a.compareTo(b));
}