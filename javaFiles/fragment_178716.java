String input = "Sat Feb 17 2012";
String[] myDate = input.split("\\s+");
int year = Integer.parseInt(myDate[3]);
String monthString = myDate[1];
int mo = monthString.equals("Jan")? Calendar.JANUARY :
             monthString.equals("Feb")? Calendar.FEBRUARY :
             monthString.equals("Mar")? Calendar.MARCH :
             monthString.equals("Apr")? Calendar.APRIL :
             monthString.equals("May")? Calendar.MAY :
             monthString.equals("Jun")? Calendar.JUNE :
             monthString.equals("Jul")? Calendar.JULY :
             monthString.equals("Aug")? Calendar.AUGUST :
             monthString.equals("Sep")? Calendar.SEPTEMBER :
             monthString.equals("Oct")? Calendar.OCTOBER :
             monthString.equals("Nov")? Calendar.NOVEMBER :
             monthString.equals("Dec")? Calendar.DECEMBER : 0;
int day = Integer.parseInt(myDate[2]);
Calendar c = Calendar.getInstance();
c.set(year, mo, day);
long then = c.getTimeInMillis();
Time current_time = new Time();
current_time.setToNow();
long now = current_time.toMillis(false);
long future = then - now;
Date d = new Date(future);
//TODO use d as you need.
Toast.makeText(this, "Milliseconds to future date="+future, Toast.LENGTH_SHORT).show();