DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    DateFormat monthFormat = new SimpleDateFormat("MM-yyyy", Locale.US);
    Calendar cal = Calendar.getInstance();
    cal.setTime(format.parse("26-04-2019"));
    for (int i = 0; i < 3; i++){
        System.out.println("currentDate: " + monthFormat.format(cal.getTime())); // print current month

        cal.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("first date: " + format.format(cal.getTime())); // print first date

        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);

        System.out.println("last date: " + format.format(cal.getTime())); // print last date


        cal.add(Calendar.MONTH, -1);
    }