final Calendar date = Calendar.getInstance();
date.set(2012, Calendar.SEPTEMBER, 17);

int prevDayOfWeekInMonth = date.get(Calendar.DAY_OF_WEEK_IN_MONTH);
int prevDayOfWeek = date.get(Calendar.DAY_OF_WEEK);

date.add(Calendar.MONTH, 1);
date.set(Calendar.DAY_OF_WEEK, prevDayOfWeek);
date.set(Calendar.DAY_OF_WEEK_IN_MONTH, prevDayOfWeekInMonth);