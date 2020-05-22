Calendar c = Calendar.getInstance();
c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
c.set(Calendar.HOUR_OF_DAY, 15);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
if (c.getTimeInMillis() - Calendar.getInstance().getTimeInMillis() < 0)
    c.add(Calendar.DAY_OF_YEAR, 7);
return c.getTimeInMillis();