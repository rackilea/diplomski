public static List<String> getExpressions( int startHour, int startMinute, int endHour, int endMinute, int interval) {
  List<String> expressions = new ArrayList<>();

  //If the start minute is greater than the interval we need a separate expression for the first hour
  if( startMinute >= interval ) {     
    expressions.add( String.format( "0 %d/%d %d * * ?", startMinute, interval, startHour ) );

    //the main expression needs to start as early as possible in the second hour, 
    //e.g. if you start at 9:33 and have 5 minute intervals it would need to start at 10:03  (9+1 = 10, 33%5 = 3)
    startMinute %= interval;
    startHour++;
  }

  //If the end minute is lower than the last run in the end hour we need a separate epxression for the last hour
  if( endMinute < (  startMinute + 60 - interval ) ) {     
    expressions.add( String.format( "0 %d-%d/%d %d * * ?", startMinute, endMinute, interval, endHour ) );

    //the main expression needs to run up to the second to last hour
    endHour--;
  }

  //if the main expression would still be 2+ hours in length
  if( startHour < endHour ) {        
    expressions.add( String.format( "0 %d/%d %d-%d * * ?", startMinute, interval, startHour, endHour ) );
  }
  //if the main expression is only 1 hour long don't use x-x
  else if ( startHour == endHour ) {
    expressions.add( String.format( "0 %d/%d %d * * ?", startMinute, interval, startHour ) );
  }

  return expressions;
}