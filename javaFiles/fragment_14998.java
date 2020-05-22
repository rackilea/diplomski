Time{
  private  int hour;
  private int minutes;

  public Time(int hour; int minutes) {
     this.hour = hour;
      this.minutes = minutes;
   }

   public toString(){
      return hour + “:” + minutes
   }

   public static Time fromTotalMinutes(int totalMinutesSinceZeroOclock){
      return new Time(totalMinutesSinceZeroOclock / 60; totalMinutesSinceZeroOclock / 60);
   }
}