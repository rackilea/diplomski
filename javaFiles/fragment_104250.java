SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

System.out.println("Last 7 days (starting today):");
Calendar cal = Calendar.getInstance(); // Initialized to today/now
for (int i = 0; i < 7; i++) {
    System.out.println("  " + sdf.format(cal.getTime()));
    cal.add(Calendar.DAY_OF_MONTH, -1); // Update to previous day at same time-of-day
}