Calendar cal = Calendar.getInstance();
cal.setTime(startDate);
cal.add(Calendar.DATE, -30);
cal.set(HOUR, 0);
cal.set(MINUTE, 0);
cal.set(SECOND, 0);
cal.set(MILLISECOND, 0);
Date dateBefore30DayFromStartDate = cal.getDate();