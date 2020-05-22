DateFormat inDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // inputFormat
    DateFormat TodayDF = new SimpleDateFormat("HH'h'mm"); //OutputFormat For today and yesterday
    DateFormat FullDF = new SimpleDateFormat("dd MMM - HH'h'mm"); //Outputformat long

    Date inDate = inDF.parse("2014-06-05 17:50:50");
    //calendar for inputday
    Calendar inCal = new GregorianCalendar();
    inCal.setTime(inDate);
    //startOfToday
    Calendar cStartOfDate = new GregorianCalendar();
    cStartOfDate.set(Calendar.HOUR_OF_DAY, 0);
    cStartOfDate.set(Calendar.MINUTE, 0);
    cStartOfDate.set(Calendar.SECOND, 0);
    cStartOfDate.set(Calendar.MILLISECOND, 0);
    //endOfToday    
    Calendar cEndOfDate = new GregorianCalendar();
    cEndOfDate.set(Calendar.HOUR_OF_DAY, 23);
    cEndOfDate.set(Calendar.MINUTE, 59);
    cEndOfDate.set(Calendar.SECOND, 59);

     //startOfYesterday
    Calendar cStartOfYesterday = new GregorianCalendar();
    cStartOfYesterday.set(Calendar.HOUR_OF_DAY, 0);
    cStartOfYesterday.set(Calendar.MINUTE, 0);
    cStartOfYesterday.set(Calendar.SECOND, 0);
    cStartOfYesterday.set(Calendar.MILLISECOND, 0);

     //endOfYesterday
    Calendar cEndOfYesterday = new GregorianCalendar();
    cEndOfYesterday.set(Calendar.HOUR_OF_DAY, 23);
    cEndOfYesterday.set(Calendar.MINUTE, 59);
    cEndOfYesterday.set(Calendar.SECOND, 59);

    if (cStartOfDate.before(inCal) && cEndOfDate.after(inCal)){
      System.out.println("Today "+TodayDF.format(inDate));
    } else if (cStartOfYesterday.before(inCal) && cEndOfYesterday.after(inCal)){
      System.out.println("Yesterday"+TodayDF.format(inDate));
    }  else {

      System.out.println(FullDF.format(inDate));
    }