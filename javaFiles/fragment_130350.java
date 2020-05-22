Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 15);
cal.set(Calendar.MONTH, 9);
cal.set(Calendar.YEAR, 2013);
Date fromDate = cal.getTime();

Calendar endCal = Calendar.getInstance();
endCal.set(Calendar.DATE, 15);
endCal.set(Calendar.MONTH, 11);
endCal.set(Calendar.YEAR, 2013);
Date toDate = endCal.getTime();

List<Date> datesList = new ArrayList<>(25);
datesList.add(fromDate);

Calendar calendar = Calendar.getInstance();
calendar.setTime(fromDate);
do {

    calendar.add(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DATE, -1);

    if (calendar.getTime().before(toDate)) {

        datesList.add(calendar.getTime());

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, 0);

        if (calendar.getTime().before(toDate)) {

            datesList.add(calendar.getTime());

        }

    }

} while (calendar.getTime().before(toDate));

datesList.add(toDate);

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
for (Date d : datesList) {
    System.out.println(sdf.format(d));
}