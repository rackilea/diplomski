public Period(Date start, Date end) {
    // Failing defensive copy.
    start = (Date)start.clone();
    end   = (Date)end  .clone();

    if (start.compareTo(end) > 0)
        throw new IllegalArgumentExcpetion();
    this.start = start;
    this.end = end;
}