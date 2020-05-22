Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 44);
cal.set(Calendar.SECOND, 36);

Date startTime = cal.getTime();

cal.add(Calendar.HOUR, -1);
Date endTime = cal.getTime();

System.out.println("startTime = " + startTime);
System.out.println("endTime = " + endTime);