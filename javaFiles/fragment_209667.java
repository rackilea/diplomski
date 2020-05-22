Calendar cal1 = Calendar.getInstance();
Calendar cal2 = Calendar.getInstance();
cal1.set(2011, 03, 04);
cal2.set(2011, 04, 04);
long milis1 = cal1.getTimeInMillis();
long milis2 = cal2.getTimeInMillis();
long diff = milis2 - milis1;
long days = diff / (24 * 60 * 60 * 1000);