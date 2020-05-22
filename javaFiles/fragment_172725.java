Calendar startCalendar = Calendar.getInstance();
    int startTimeZoneOffset = TimeZone.getTimeZone(timeZone).getOffset(startDate.getTime()) / 1000 / 60;
    startCalendar.setTime(startDate);
    startCalendar.add(Calendar.MINUTE, startTimeZoneOffset);

    Calendar nowCalendar = Calendar.getInstance();
    int nowTimeZoneOffset = nowCalendar.getTimeZone().getOffset(new Date().getTime()) / 1000 / 60;
    nowCalendar.setTime(new Date());
    nowCalendar.add(Calendar.MINUTE, nowTimeZoneOffset);

    return startCalendar.before(nowCalendar);