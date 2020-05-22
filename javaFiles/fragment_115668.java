Calendar c = Calendar.getInstance(TimeZone.getTimeZone("US/Eastern"));
Calendar target3 = Calendar.getInstance(TimeZone.getTimeZone("US/Eastern"));
target3.set(Calendar.HOUR_OF_DAY, 15);
target3.set(Calendar.MINUTE, 0);
target3.set(Calendar.SECOND, 0);
target3.set(Calendar.MILLISECOND, 0);

if (target3.before(c)) {
  target3.add(Calendar.DATE, 1);
}

System.out.println(target3.getTimeInMillis() - c.getTimeInMillis());