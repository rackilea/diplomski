String sql =
    "SELECT route FROM arrivaltimes INNER JOIN stops"
    + " ON arrivaltimes.stop_id = stops.stop_id"
    + " WHERE weekday = ?"
    + " and arrivaltime = ?"
    + " and name LIKE ?";
PreparedStatement preparedTime = con
    .prepareStatement(sql);
preparedTime.setString(1, day);
//preparing the proper time using java.util.Calendar
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 12);
cal.set(Calendar.MINUTE, 56);
cal.set(Calendar.SECOND, 0);
//create an instance of java.sql.Time
//Calendar#getTime returns an instance of java.util.Date
//Date#getTime returns the time in millis (long)
Time time = new Time(cal.getTime().getTime());
//setting the time
preparedTime.setTime(2, time);
preparedTime.setString(3, stopname);
ResultSet rs = preparedTime.executeQuery();