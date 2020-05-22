Date date = new Date();
    SimpleDateFormat df  = new SimpleDateFormat("YYYY-MM-dd");
    Calendar c1 = Calendar.getInstance();
    String currentDate = df.format(date);// get current date here

    // now add 30 day in Calendar instance 
    c1.add(Calendar.DAY_OF_YEAR, 30);
    df = new SimpleDateFormat("yyyy-MM-dd");
    Date resultDate = c1.getTime();
    String     dueDate = df.format(resultDate);

    // print the result
    Utils.printLog("DATE_DATE :-> "+currentDate);
    Utils.printLog("DUE_DATE :-> "+dueDate);