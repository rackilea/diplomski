for (int i = 0; i < 7; i++) {
    Date dt = calendar.getTime ();
    // now format it using SimpleDateFormat
    String val = df.format (dt);
    weekly[i] = val;
    calendar.add (Calendar.DAY_OF_WEEK, 1);
}