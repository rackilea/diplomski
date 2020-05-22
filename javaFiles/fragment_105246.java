// Set day to one, add 1 month and subtract a day
Calendar cal = Calendar.getInstance();
cal.setTime(date);
cal.set(Calendar.DAY_OF_MONTH, 1); 
cal.add(Calendar.MONTH, 1);
cal.add(Calendar.DAY_OF_MONTH, -1);
return cal.get(Calendar.DAY_OF_MONTH);