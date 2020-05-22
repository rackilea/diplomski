SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date startDate = dateFormat.parse("2019-01-01");
Date endDate = dateFormat.parse("2019-01-29");
int noOfWeek = calculateWeekNo(startDate, endDate);

   //Option 1
   public int calculateWeekNo(Date start, Date end) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(start);
        int weeks = 0;
        while (cal.getTime().before(end)) {
            cal.add(Calendar.WEEK_OF_YEAR, 1);
            weeks++;
        }
       return weeks;
    }

   // Option 2
    public static int calculateWeekNo(Date start, Date end) {
         Calendar a = new GregorianCalendar();
         Calendar b = new GregorianCalendar();
         a.setTime(start);
         b.setTime(end);
         return b.get(Calendar.WEEK_OF_YEAR) - a.get(Calendar.WEEK_OF_YEAR);
       }