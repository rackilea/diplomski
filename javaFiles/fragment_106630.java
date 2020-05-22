// you want the date part from it
Date d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2013-01-02 03:04:05");

// you want to time part from it
Date t = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2014-02-03 04:05:06");


LocalDate datePart = new LocalDate(d);
LocalTime timePart = new LocalTime(t);
LocalDateTime dateTime = datePart.toLocalDateTime(timePart);
Date result = dateTime.toDate();

// Or shrink the above 4 lines into one, as follow
// Date result = new LocalDate(d).toLocalDateTime(new LocalTime(t)).toDate();

System.out.println("result " + result);
// print out result Wed Jan 02 04:05:06 CST 2013