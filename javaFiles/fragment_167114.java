public enum Month
{
  JANUARY( "January", 31 ),
  FEBRUARY( "February", 28 ),
  ...
  DECEMBER( "December", 31 );

  private String monthName;
  private int numOfDays;

  private Month ( String monthName, int numOfDays )
  {
    this.monthName = monthName;

    this.numOfDays = numOfDays;
  }

  public String getDisplayName ( )
  {
    return monthName;
  }

  public int getNumOfDays ( )
  {
    return numOfDays;
  }
}