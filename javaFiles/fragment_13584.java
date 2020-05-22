SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd-MMM-yyyy");
for (int i = 0; i < 7; i++) {
    Calendar calendar = new GregorianCalendar();
    calendar.add(Calendar.DATE, i);
    String day = sdf.format(calendar.getTime());
    Log.i(TAG, day);
}