SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String strDate = "2014-10-28";
    Date date = sdf.parse(strDate);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, -1);
    Date yesterday = calendar.getTime();

    System.out.println(yesterday);
    System.out.println(date);