Set<MyType> set = new TreeSet<>(new Comparator<MyType>() {
   public int compare(MyType o1, MyType o2) {
      int cmp = /* compare the normal way */
      if (cmp == 0) {
          // or use System.identityHashCode()
         cmp = Integer.compare(o1.hashCode(), o2.hashCode());
         return cmp == 0 ? 1 : cmp; // returning 0 is a bad idea.
      }
   }
}