Calendar calendar = Calendar.getInstance();
//verify if the current time is past 9:40, then add one day
if (calendar.get(Calendar.HOUR) > 9 
        || (calendar.get(Calendar.HOUR) == 9 && calendar.get(Calendar.MINUTE) >= 40))
    calendar.add(Calendar.DATE, 1);
calendar.set(Calendar.HOUR_OF_DAY, 9);
calendar.set(Calendar.MINUTE, 40);
calendar.set(Calendar.SECOND, 0);