long someTime = 1382364283;
    long sTime = someTime*1000;  // multiply by 1000, not divide

    Date date = new Date(sTime);
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String formatted = format.format(date);

    System.out.println(formatted); // 21/10/2013 10:04:43