Calendar calendar = new GregorianCalendar();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    SharedPreferences shared = getSharedPreferences("your_name", MODE_PRIVATE);
    String saved_time = (shared.getString("TIME", ""));

    Date date = null,date2 = null;
    try {
        date = formatter.parse(saved_time);
    } catch (ParseException e) {
        e.printStackTrace();
    }


    String currentTime = getCurrentTimeDate();
    try {
        date2 = formatter.parse(currentTime);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    printDifference(date,date2);