Calendar cln = Calendar.getInstance().clear(); 
//by default you get a calendar with current system time

//now set the fields. for example, day:
cln.set(Calendar.YEAR, 2015);
cln.set(Calendar.MONTH, Calendar.FEBRUARY);
cln.set(Calendar.DAY_OF_MONTH, 17);
cln.set(Calendar.HOUR_OF_DAY, 18);//Calendar.HOUR for 12h-format
cln.set(Calendar.MINUTE, 27);