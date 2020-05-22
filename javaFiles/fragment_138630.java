String da = "1957-01-01";
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
Date date=df.parse(da); // parse your string to date 
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
System.out.println(df.format(calendar.getTime())); // format date