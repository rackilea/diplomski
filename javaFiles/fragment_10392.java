String myTime = "14:10";
 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
 Date d = df.parse(myTime); 
 Calendar cal = Calendar.getInstance();
 cal.setTime(d);
 cal.add(Calendar.MINUTE, 10);
 String newTime = df.format(cal.getTime());