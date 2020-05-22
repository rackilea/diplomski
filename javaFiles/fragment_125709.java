public class Clock
{

  //Instance Variables
  private int Hours;
  private int Minutes;
  private int Seconds;
  private double Cost;
  private boolean IsOn;
  private int DLS;
  int totalSeconds; 



  //Zero arg constructors
  public Clock()
  { // Start
    Hours = 10;
    Minutes = 52;
    Seconds = 23;   
    Cost = 20.00;
    IsOn = true;
    DLS = 11;
    totalSeconds = 9945;
  } // End

  //Multi-Argument Constructors

  public Clock( int Hours, int Minutes, int Seconds, double Cost , boolean IsOn, int DSL, int totalSeconds)
  { // Start
    this.Hours = Hours;
    this.Minutes = Minutes;
    this.Seconds = Seconds;
    this.Cost = Cost;
    this.IsOn = IsOn;
    this.DLS = DLS;
    this.totalSeconds = totalSeconds;
  } // End

  public void setTime(int Hours)
  {
    System.out.println(Hours + 1);
  }

  public int convertDaylightSaving(int Hours)
  {
    return Hours;
  }
    public int totalSeconds()
    {
      return totalSeconds + 5000;
    }


  //ToString Method

  public String toString()
  { //Start
    String output;
    output = "When I checked my watch the hour was: " + Hours + "\n" + 
      "When I checked my watch the minute was: " + Minutes + "\n" +
      "When I checked my watch the seconds were: " + Seconds + "\n" +
      "The Cost is: " + Cost + "\n" +
      "Is this the time right now?: " + IsOn + "\n" + 
      "The total seconds right now are: " + totalSeconds;


    return output;

  }
} // End