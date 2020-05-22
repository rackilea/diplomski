Puzzle.java:12: warning: [unchecked] unchecked conversion
        Stream<Boolean> bs1 = outer.stream().flatMap(inner -> inner.stre
am()).map(obj -> obj.hashCode() % 2 == 0);

     ^
  required: Stream<Boolean>
  found:    Stream