try {
    String startAt = "15-05-15 02:00:AM";
    String endAt = "15-05-15 06:00:AM";

    String format = "dd-MM-yy hh:mm':'a";
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    Date startDate = sdf.parse(startAt);
    Date endDate = sdf.parse(endAt);

    Calendar startCal = Calendar.getInstance();
    startCal.setTime(startDate);
    Calendar endCal = Calendar.getInstance();
    endCal.setTime(endDate);

    while (endCal.after(startCal)) {

        String start = sdf.format(startCal.getTime());
        startCal.add(Calendar.MINUTE, 60);
        String to = sdf.format(startCal.getTime());

        System.out.println("Start Time : " + start + "; End Time : " + to);

    }

} catch (ParseException exp) {
    exp.printStackTrace();
}