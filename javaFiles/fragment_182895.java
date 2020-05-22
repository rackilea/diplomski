SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    String dateInString = "7-07-2014";

    try {

        Date date = formatter.parse(dateInString);
        System.out.println(date);
        System.out.println(formatter.format(date));

    } catch (ParseException e) {
        e.printStackTrace();
    }