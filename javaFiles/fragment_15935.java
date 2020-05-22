// n and month starts from 1 (for first day/month)
Date nthWeekdayInMonth( int n, int month, int year ) {
  new DateDSL().with {
    every.weekday.in."${months[month-1]}"( year )
  }[ n - 1 ]
}

println nthWeekdayInMonth( 7, 4, 2011 )