String dt = "15-07-2016";  
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(dt));
c.add(Calendar.DATE, 1);  // number of days to add
dt = sdf.format(c.getTime());