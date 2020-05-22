SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
    String CURRDATE    = "08-02-2016";
    String EFFDATE     = "02-02-2017";   

    Date startdate = formatter.parse(CURRDATE);
    Date enddate   = formatter.parse(EFFDATE);

    Calendar startCalendar = new GregorianCalendar();
    startCalendar.setTime(startdate);

    Calendar endCalendar = new GregorianCalendar();
    endCalendar.setTime(enddate);

    int monthCount = 0;
    int firstDayInFirstMonth = startCalendar.get(Calendar.DAY_OF_MONTH);
    startCalendar.set(Calendar.DAY_OF_MONTH, 1);
    endCalendar.add(Calendar.DAY_OF_YEAR, -firstDayInFirstMonth+1);

    while (!startCalendar.after(endCalendar)) {     
        startCalendar.add(Calendar.MONTH, 1);
        ++monthCount;
    }

    startCalendar.add(Calendar.MONTH, -1); --monthCount;
    int remainingDays = 0;
    while (!startCalendar.after(endCalendar)) {
        startCalendar.add(Calendar.DAY_OF_YEAR, 1);
        ++remainingDays;
    }

    startCalendar.add(Calendar.DAY_OF_YEAR, -1);
    --remainingDays;

    int lastMonthMaxDays = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    if (remainingDays >= lastMonthMaxDays) {
        ++monthCount;
        remainingDays -= lastMonthMaxDays;
    }

    int diffMonth = monthCount; 
    int diffDay = remainingDays; 

    System.out.println("diffMonth==="+diffMonth +" Month(s) and " + diffDay + " Day(s)");