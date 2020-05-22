SimpleDateFormat format = new SimpleDateFormat("hh:mm");
Date date1 = format.parse(timestart);
Date date2 = format.parse(timeend);
Date date3 = format.parse(breakStart);       // Start time of break
Date date4 = format.parse(breakEnd);         // End time of break

long mills = date2.getTime() - date1.getTime() - (date4.getTime() - date3.getTime());
int hours = (int)(mills/(1000 * 60 * 60));
int mins = (int) mills/(1000*60) % 60;