/**
    * @param time1 dateFrom in millis. E.g. returned by System.currentTimeMillis()
    * @param time2 dateTo in millis
    * @param mHour hours in your time zone
    * @param mMinute minutes in your time zone
    */
   public static boolean compareTime(long time1, long time2, int mHour, int mMinute)  
   {
      final LocalTime timeFrom = new LocalTime(time1);
      final LocalTime timeTo = new LocalTime(time2);
      final LocalTime time = new LocalTime(mHour, mMinute);
      final boolean isSameDay = timeFrom.isBefore(timeTo); // it is correct, because (time2 - time1 < 24 hours)
      return isSameDay ? (time.isAfter(timeFrom) && time.isBefore(timeTo))
         :  (time.isAfter(timeFrom) || time.isBefore(timeTo));
   }