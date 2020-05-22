class XyzComparator implements Comparator<Foo> {
    @Override
    public int compare(Foo foo1, Foo foo2) {
          if(foo1.x != foo2.x) {
               return Integer.compare(foo1.x, foo2.x);
          }
          if(foo1.y != foo2.y) {
               return Integer.compare(foo1.y, foo2.y);
          }
          return Integer.compare(foo1.z, foo2.z);
    }
}