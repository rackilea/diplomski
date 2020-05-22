Comparator<Interval> c = new Comparator<Interval>() {

  @Override
  public int compare(Interval o1, Interval o2) {
    return o1.start - o2.start;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Comparator<?>))
      return false;
    @SuppressWarnings("unchecked") /* We'll catch this below. */
    Comparator<Interval> that = (Comparator<Interval>) obj;
    return 
       IntStream.rangeClosed(Integer.MIN_VALUE, Integer.MAX_VALUE)
      .mapToObj(Interval::new)
      .allMatch(o1 -> {
         return
            IntStream.rangeClosed(Integer.MIN_VALUE, Integer.MAX_VALUE)
           .mapToObj(Interval::new)
           .allMatch(o2 -> {
              int sig = Integer.signum(compare(o1, o2));
              try {
                return Integer.signum(that.compare(o1, o2)) == sig;
              } catch (ClassCastException ex) {
                return false;
              }
            });
       });
  }

};