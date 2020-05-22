DateTime dateTime1 = new DateTime(date1);
DateTime dateTime2 = new DateTime(date2);

List<Date> allDates = new ArrayList();

while( dateTime1.before(dateTime2) ){
   allDates.add( dateTime1.toDate() );
   dateTime1 = dateTime1.plusDays(1);
}