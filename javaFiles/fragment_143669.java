Ordering.explicit(idList)
     // constructs a "fluent Comparator" that compares elements in the
     // explicitly specified order
  .onResultOf(new Function<MyObject, Id>() {
    public Id apply(MyObject o) { return o.getId(); }
   }) // make this a Comparator<MyObject> that compares on IDs
  .sortedCopy(myObjects); // get the sorted copy of the collection