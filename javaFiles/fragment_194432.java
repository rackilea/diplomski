SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    String dateString = sdf.format(new Date());
    Date date = null;
    try {
        date = sdf.parse("10/16/2015");
    } catch (ParseException objcPException) {
        // TODO Auto-generated catch block
        objcPException.printStackTrace();
    }
    System.out.println(date);
    System.out.println(dateString);