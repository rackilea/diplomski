Calendar start = Calendar.getInstance();
start.setTime(startDate);
Calendar end = Calendar.getInstance();
end.setTime(endDate);

for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
    System.out.println(date);
}