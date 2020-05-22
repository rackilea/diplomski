SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss");
    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d = input.parse("2015-02-24T13:00:00.000Z");
    System.out.println(d);
    String formattedTime = output.format(d);
    System.out.println(formattedTime);