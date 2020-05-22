String time = "7:00 PM";
SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
format.setTimeZone(TimeZone.getTimeZone("EST"));
try {
    Date date = format.parse(time);
    System.out.println(format.getTimeZone().getID()+": "+format.format(date));
    format.setTimeZone(TimeZone.getDefault());
    System.out.println(format.getTimeZone().getID()+": "+format.format(date));
} catch (ParseException e) {
    e.printStackTrace();
}