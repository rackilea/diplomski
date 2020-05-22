//Date date = new SimpleDateFormat("dd/MM/yyyy z").parse("27/03/2016 CET");
Date date = new SimpleDateFormat("dd/MM/yyyy z").parse("28/03/2016 CET");

Calendar cal = Calendar.getInstance();
cal.setTime(date);
cal.set(Calendar.HOUR_OF_DAY, 2);
cal.set(Calendar.MINUTE, 48);
cal.set(Calendar.MILLISECOND, 0);

System.out.println(cal.getTime());