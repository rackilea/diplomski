Calendar calendar = Calendar.getInstance();
calendar.setTime(yourDate);
calendar.set(Calendar.YEAR, 1970);
calendar.set(Calendar.MONTH, Calendar.JANUARY);
calendar.set(Calendar.DATE, 1);
yourDate = calendar.getTime();