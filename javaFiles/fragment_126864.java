final DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd"); // like 'SimleDateFormat'
final List<String> month = Arrays.asList("2014-03-31", "2014-04-01", "2014-04-02", "2014-04-03", "2014-04-04",
          "2014-04-07", "2014-04-08", "2014-04-09", "2014-04-10", "2014-04-11",
          "2014-04-14", "2014-04-15", "2014-04-16", "2014-04-17", "2014-04-18",
          "2014-04-21", "2014-04-22", "2014-04-23", "2014-04-24", "2014-04-25",
          "2014-04-28", "2014-04-29", "2014-04-30", "2014-05-01", "2014-05-02");
final DateTime lastDate = dtf.parseDateTime(month.get(month.size() - 1)); // last date in 'month' array
final MutableDateTime dateIterator = new MutableDateTime(dtf.parseDateTime(month.get(0))); // first date in 'month' array
int count = 0;
for (;;dateIterator.addDays(1)) // start iteration day by day 
{
   count++;
   final String dateAsString = dtf.print(dateIterator); // convert iterator to String
   if (month.contains(dateAsString)) // 'month' array contains current date
   {
      System.out.println("Date: " + dateAsString);
   }
   else
   {  
      if (dateIterator.getDayOfWeek() == 1   // current date is first day of week but record is absent in db
          && dateIterator.isAfter(lastDate)) // and all records from db are processed
                                             // so let's break for-loop

      {
         break; // break for-loop
      }   
      System.out.println("not exists");
   }
   System.out.println("Num Day: " + String.valueOf(count));
}