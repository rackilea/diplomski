String rDate="04/22/1980 11:30:20"; // your received String date
 DateFormat df=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");// date format
 Date date=df.parse(rDate);// parse String to date
 Calendar calendar=Calendar.getInstance();
 calendar.setTime(date); // set calender instance to date value
 calendar.add(Calendar.YEAR,1); // add one year to current
 System.out.println(df.format(calendar.getTime()));