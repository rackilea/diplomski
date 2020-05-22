String date = "1/13/2012";
SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
Date convertedDate = dateFormat.parse(date);
Calendar c = Calendar.getInstance();
c.setTime(convertedDate);
c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));