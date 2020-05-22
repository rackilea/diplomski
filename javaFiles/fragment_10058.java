String dateFormat = "dd-MMM-yy";
    String dateString = "02-Mar-00";
    DateFormat df = new SimpleDateFormat(dateFormat);
    df.setLenient(false);
    try {
        Date date = df.parse(dateString);
        System.out.println(date.toString());
    } catch (ParseException e) {
        e.printStackTrace();
    }