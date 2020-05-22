SimpleDateFormat format = new SimpleDateFormat("hh:mm");
Date date1 = format.parse(timestart);
Date date2 = format.parse(timeend);
long breakLengthMillis = TimeUnit.MINUTES.toMillis(breakLength)

long mills = date2.getTime() - date1.getTime() - breakLengthMillis;
int hours = (int)(mills/(1000 * 60 * 60));
int mins = (int) mills/(1000*60) % 60;