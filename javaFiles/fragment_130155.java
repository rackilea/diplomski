String sDate = "2018-01-17 00:00:00";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = df.parse(sDate);

    SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
    System.out.println(df1.format(date));