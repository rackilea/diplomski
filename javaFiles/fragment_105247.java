Calendar cal = Calendar.getInstance();
cal.setTime(date);
cal.set(Calendar.DAY_OF_MONTH, 1); 
int myMonth=cal.get(Calendar.MONTH);

while (myMonth==cal.get(Calendar.MONTH)) {
  System.out.print(cal.getTime());
  cal.add(Calendar.DAY_OF_MONTH, 1);
}