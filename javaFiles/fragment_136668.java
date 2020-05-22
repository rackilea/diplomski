java.util.Calendar c = Calendar.getInstnace();
c.set(Calendar.DAY_OF_THE_MONTH, day_that_you want);
c.set(Calendar.MONTH, month_that_you want);
c.set(Calendar.YEAR, year_that_you want);

java.lwuit.Calendar cal = new java.lwuit.Calendar();
cal.setDate(c.getDate().getTime());