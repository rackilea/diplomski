public static void getDaysOfWeek(int week) {
    Calendar c = Calendar.getInstance();
    // Set the calendar to monday of the current week
    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    c.add(Calendar.DATE, week * 7);
    // Print dates of the current week starting on Monday
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    for (int i = 0; i < 7; i++) {
        System.out.println(df.format(c.getTime()));
        c.add(Calendar.DAY_OF_MONTH, 1);
    }
}