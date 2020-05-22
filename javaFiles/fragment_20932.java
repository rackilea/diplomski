String dt = "12-17-2014"; // Start date
SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(dt));
c.add(Calendar.DATE, 1); // number of days to add
dt = sdf.format(c.getTime());