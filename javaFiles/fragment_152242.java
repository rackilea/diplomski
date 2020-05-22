String x = "1086073200000"

DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

long milliSeconds= Long.parseLong(x);
System.out.println(milliSeconds);

Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(milliSeconds);
System.out.println(formatter.format(calendar.getTime()));