GregorianCalendar c = new GregorianCalendar();
c.setTime(reportDate);

String[] toAdd = "120:34:29".split(":");

int hours = Integer.parseInt(toAdd[0]);
int mins = Integer.parseInt(toAdd[1]);
int secs = Integer.parseInt(toAdd[2]);

c.add(Calendar.SECOND, secs);
c.add(Calendar.MINUTE, mins);
c.add(Calendar.HOUR, hours);

java.util.Date targetFinish = c.getTime();

SystemOutPrintln(targetFinish.toString());