try {
    String startdateString = "Mon Jul 29 02:00:00 CEST 2013";
    SimpleDateFormat fromUser2 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);

    System.out.println(fromUser2.parse(startdateString));
} catch (ParseException e) {
    e.printStackTrace();
}