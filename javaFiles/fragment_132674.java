Date d = new Date(1409716800);
    Date d1 = new Date(1409716801);
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy-HH:mm:ss:SSS");
    String formattedDate = sdf.format(d);
    String formattedDate1 = sdf.format(d1);         

    Log.d("time", formattedDate);
    Log.d("time", formattedDate1);