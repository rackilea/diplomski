class WeekdayIterator {
  private static GOOD_DAYS = [Calendar.MONDAY..Calendar.FRIDAY].flatten()
  private Calendar c = Calendar.instance
  private Date nxt
  private int month, year

  WeekdayIterator( int month, int year ) {
    c.set( year, month, 1 )
    this.month = month
    nxt = nextWeekday()
  }
  private Date nextWeekday() {
    while( c.get( Calendar.MONTH ) == month ) {
      if( c.get( Calendar.DAY_OF_WEEK ) in GOOD_DAYS ) {
        Date ret = c.time.clearTime()
        c.add( Calendar.DATE, 1 )
        return ret
      }
      c.add( Calendar.DATE, 1 )
    }
    null
  }
  Iterator iterator() {
    [ hasNext:{ nxt != null }, next:{ Date ret = nxt ; nxt = delegate.nextWeekday() ; ret } ] as Iterator
  }
}