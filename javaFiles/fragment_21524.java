public static int thanksgiving(int year)
{
  int day = firstOfMonth( year );
  if ( day == THURS ) 
  {
    return (int) 22;
  }
  if ( day > THURS )
  {
    return (int) 29 - ( day - THURS );
  }
  if ( day < THURS )
  {
    return (int) 22 + ( THURS + day );
  }
}