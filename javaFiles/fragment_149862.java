final Comparator<? super Interval> comparator
  = (i1, i2) -> Integer.compare(i1.start, i2.start);
int start = Collections.binarySearch(intervals, newInterval, comparator);
int skip = start >= 0 ? start : -start - 1;
int end = Collections.binarySearch(intervals.subList(skip, intervals.size()),
                                   new Interval(newInterval.end, 0),
                                   comparator);