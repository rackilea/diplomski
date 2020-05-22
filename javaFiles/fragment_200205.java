int sum = 0
for( String hhmm : workingTimes ){
  String[] split = hhmm.split( ":", 2 );
  int mins = Integer.valueOf(split[ 0 ]) * 60 + Integer.valueOf( split[ 1 ] );
  sum += mins;
}

String formattedWorkingTime = (int)Math.floor(sum/60) + ":" + ( sum % 60 );