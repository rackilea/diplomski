// create a calendar
      Calendar cal = Calendar.getInstance();
      cal.setTime(datetime);  //use java.util.Date object as arguement
      // get the value of all the calendar date fields.
      System.out.println("Calendar's Year: " + cal.get(Calendar.YEAR));
      System.out.println("Calendar's Month: " + cal.get(Calendar.MONTH));
      System.out.println("Calendar's Day: " + cal.get(Calendar.DATE));