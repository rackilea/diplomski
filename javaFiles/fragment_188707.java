Calendar cal = Calendar.getInstance();
cal.set(2015, Calendar.JUNE, 01); // Comment this out for today...
cal.add(Calendar.YEAR, -18);
cal.add(Calendar.DATE, -1);
Date date = cal.getTime();
System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));