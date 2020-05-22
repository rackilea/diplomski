Date currentTime = new Date();
    DateFormat ausFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
    ausFormat.setTimeZone(TimeZone.getTimeZone("Australia/Melbourne"));

    //get the time string in australian timezone
    String ausTime  = ausFormat.format(currentTime);

    //Convert the above time string in local date object
    DateFormat currentFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
    //optional: set the timezone as Asia/Calcutta
    currentFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
    Date ausTimeInLocal = currentFormat.parse(ausTime);

    //get the time stamp object using above date object
    Timestamp ausTimeStampInLocal = new Timestamp(ausTimeInLocal.getTime());