/** Given a reference LocalDate and a day of week, eg DateTimeConstants.MONDAY 
       Returns the nearest date with that day of week */
   public static LocalDate getNearestDayOfWeek(LocalDate t0,int dow) {
        LocalDate t1 = t0.withDayOfWeek(dow);
        LocalDate t2 = t1.isBefore(t0) ? t1.plusWeeks(1) : t1.minusWeeks(1);
        return  Math.abs(Days.daysBetween(t1, t0).getDays()) < 
                Math.abs(Days.daysBetween(t2, t0).getDays()) ? t1 : t2;
   }