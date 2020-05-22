DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

long now = (long)(TimeStampSeconds.longValue() * 1000);

Calendar calendar = Calendar.getInstance();
calendar.clear();
calendar.set(2007, 0, 1);
calendar.setTimeInMillis(calendar.getTimeInMillis() + now);

System.out.println(now + " = " + formatter.format(calendar.getTime()));