List<Date> dates = new ArrayList<>(25);

Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 15);
cal.set(Calendar.MONTH, 9);
cal.set(Calendar.YEAR, 2013);

Calendar endCal = Calendar.getInstance();
endCal.set(Calendar.DATE, 15);
endCal.set(Calendar.MONTH, 11);
endCal.set(Calendar.YEAR, 2013);

dates.add(cal.getTime());
while (cal.before(endCal)) {

    cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
    dates.add(cal.getTime());
    if (cal.before(endCal)) {
        cal.add(Calendar.DATE, 1);
        dates.add(cal.getTime());
    }

}

dates.remove(dates.size() - 1);
dates.add(endCal.getTime());
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
for (Date d : dates) {
    System.out.println(sdf.format(d));
}