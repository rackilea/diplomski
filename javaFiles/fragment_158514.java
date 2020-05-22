String days[] ={"Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday"};
    int year = 2014;
    int month = 6;
    int dayOfMonth = 25;
    Calendar myCalendar = new GregorianCalendar(year, month, dayOfMonth);
    System.out.print(days[myCalendar.get(Calendar.DAY_OF_WEEK)]);