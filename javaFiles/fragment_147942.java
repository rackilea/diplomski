private static final Comparator<Interval> orderByStart = new Comparator<Interval>() {
  @Override
  public int compare(Interval o1, Interval o2) {
    return o1.start - o2.start;
  }    
};