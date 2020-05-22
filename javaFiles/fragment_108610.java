Calendar now = Calendar.getInstance();
now.setTime(new Date());

Calendar cal = Calendar.getInstance();
cal.setTime(timeOfFirstCollectionInMillis);
cal.set(Calendar.YEAR, now.get(Calendar.YEAR));