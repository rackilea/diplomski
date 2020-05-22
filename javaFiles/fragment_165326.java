Calendar cal = Calendar.getInstance();
cal.setFirstDayOfWeek(Calendar.SUNDAY);
cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

Calendar today = Calendar.getInstance();

while (cal.before(today)) {
    System.out.println(cal.getTime());
    cal.add(Calendar.DATE, 1);
}