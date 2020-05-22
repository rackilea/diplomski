public static LocalDateTime addWorkingMinutes(LocalDateTime date, long minutes) {
    if (date.getHour() < 8) {
      // Working day hasn't started. Reset date to start of this working day
      date = date.withHour(8).withMinute(0).withSecond(0);
    }

    // Take care of weekends
    if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
      date = date.plusDays(2);
    } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
      date = date.plusDays(1);
    }

    LocalDateTime endOfCurrentWorkingDay = date.withHour(16).withMinute(0).withSecond(0);

    // Get minutes from date to endOfCurrentWorkingDay
    long minutesCovered = ChronoUnit.MINUTES.between(date, endOfCurrentWorkingDay);
    if (minutesCovered > minutes) {
      // If minutesCovered covers the minutes value passed, that means result is the same working
      // day. Just add minutes and return
      return date.plusMinutes(minutes);
    } else {
      // Calculate remainingMinutes, and then recursively call this method with next working day
      long remainingMinutes = minutes - minutesCovered;
      return addWorkingMinutes(endOfCurrentWorkingDay.plusDays(1).withHour(8), remainingMinutes);
    }
}