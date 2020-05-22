DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
Date myDate = new Date(System.currentTimeMillis());
System.out.println("result is "+ dateFormat.format(myDate));
Calendar cal = Calendar.getInstance();
cal.setTime(myDate);
cal.add(Calendar.DATE, -10);
System.out.println(dateFormat.format(cal.getTime()));