// Get calendar set to current date and time
Calendar c = Calendar.getInstance();

// Set the calendar to monday of the current week
c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

// Print dates of the current week starting on Monday
DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
for (int i = 0; i < 7; i++) {
    System.out.println(df.format(c.getTime()));
    c.add(Calendar.DATE, 1);
}