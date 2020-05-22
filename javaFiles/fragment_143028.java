ResultSet rs = null;

Date date = rs.getDate("date");

TimeZone userTimeZone = TimeZone.getTimeZone(rs.getString("time_zone"));

Calendar c = Calendar.getInstance(userTimeZone);
c.set(1900 + date.getYear(), date.getMonth(),
    date.getDate(), date.getHours(), 
    date.getMinutes(), date.getSeconds());

//what you are actually interested in
long utcTimestamp = c.getTimeInMillis();