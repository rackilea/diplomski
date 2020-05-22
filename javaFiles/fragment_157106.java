Calendar midnight = Calendar.getInstance ();

midnight.set (Calendar.HOUR_OF_DAY, 0);
midnight.set (Calendar.MINUTE, 0);
midnight.set (Calendar.SECOND, 0);
midnight.set (Calendar.MILLISECOND, 0);

long millisSinceMidnight = System.currentTimeMillis() - midnight.getTimeInMillis();