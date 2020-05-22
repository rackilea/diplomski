List<Date> disable = new ArrayList<>();

Calendar cal = Calendar.getInstance();
cal.set(Calendar.DAY_OF_MONTH, 1);
int month = cal.get(Calendar.MONTH);
do {
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY)
        disable.add(cal.getTime());
    cal.add(Calendar.DAY_OF_MONTH, 1);
} while (cal.get(Calendar.MONTH) == month);

SimpleDateFormat fmt = new SimpleDateFormat("EEE M/d/yyyy");
for (Date date : disable)
    System.out.println(fmt.format(date));