String time = "7:00 PM";
SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
try {
    Date date = format.parse(time);
    format.setTimeZone(TimeZone.getTimeZone("EST"));
    System.out.println(format.getTimeZone().getID()+": "+format.format(date));

    format.setTimeZone(TimeZone.getTimeZone("PST"));
    System.out.println(format.getTimeZone().getID()+": "+format.format(date));

    format.setTimeZone(TimeZone.getTimeZone("UCT"));
    System.out.println(format.getTimeZone().getID()+": "+format.format(date));

    format.setTimeZone(TimeZone.getDefault()); // The user's timezone.
    System.out.println(format.getTimeZone().getID()+": "+format.format(date));
} catch (ParseException e) {
    e.printStackTrace();
}
/*
EST: 07:00 PM
PST: 04:00 PM
UCT: 12:00 AM
America/New_York: 07:00 PM
*/