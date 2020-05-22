SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
Period weekPeriod = new Period().withWeeks(1);
DateTime startDate = new DateTime(2012, 1, 1, 0, 0, 0, 0 );
DateTime endDate = new DateTime(2013, 1, 1, 0, 0, 0, 0 );
Interval i = new Interval(startDate, weekPeriod );
while(i.getEnd().isBefore( endDate)) {
    System.out.println( "week : " + i.getStart().getWeekOfWeekyear()
            + " start: " + df.format( i.getStart().toDate() )
            + " ending: " + df.format( i.getEnd().minusMillis(1).toDate()));
    i = new Interval(i.getStart().plus(weekPeriod), weekPeriod);
}