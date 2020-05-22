String test = "2016-02-25T07:05:22.0Z";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.'0Z'");

    Date date = null;
    try
    {
        date = formatter2.parse(test);
    }
    catch (ParseException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(date);
    System.out.println(formatter.format(date));