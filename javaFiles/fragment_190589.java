class Weekday extends Enum
{
  public static final Weekday MONDAY  = new Weekday( "MONDAY",   0 );
  public static final Weekday TUESDAY = new Weekday( "TUESDAY ", 1 );
  // more constants

  private Weekday( String s, int i )
  {
    super( s, i );
  }

  // more methods
}