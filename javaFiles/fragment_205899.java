Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);

Date startTime = cal.getTime();
cal.set(Calendar.HOUR, 23);
cal.set(Calendar.MINUTE, 59);
Date endTime = cal.getTime();

System.out.println(startTime);
System.out.println(endTime);

SpinnerWindowModel hourModel = new SpinnerWindowModel(Calendar.HOUR, cal, 0, 0, 23, 1);
SpinnerWindowModel minuteModel = new SpinnerWindowModel(Calendar.HOUR, cal, 0, 0, 59, 15);

JSpinner hour = new JSpinner(hourModel);
JSpinner minute = new JSpinner(minuteModel);

add(hour);
add(new JLabel(":"));
add(minute);