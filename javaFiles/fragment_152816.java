List<java.sql.Time> intervals = new ArrayList<>(25);
// These constructors are deprecated and are used only for example
java.sql.Time startTime = new java.sql.Time(11, 0, 0);
java.sql.Time endTime = new java.sql.Time(12, 0, 0);

intervals.add(startTime);

Calendar cal = Calendar.getInstance();
cal.setTime(startTime);
while (cal.getTime().before(endTime)) {
    cal.add(Calendar.MINUTE, 15);
    intervals.add(new java.sql.Time(cal.getTimeInMillis()));
}

SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
for (java.sql.Time time : intervals) {
    System.out.println(sdf.format(time));
}