public static int thanksgiving(int year){
  int day = firstOfMonth( year );
  if ( day == THURS ) {
    return (22;
  } else if ( day > THURS ) {
    return 29 - ( day - THURS );
  } else { // else without the if
    // we know that ( day < THURS )
    return 22 + ( THURS + day );
  }
}