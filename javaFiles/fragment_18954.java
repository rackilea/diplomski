TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
TimeZone.setDefault(utcTimeZone);
Calendar calendar = Calender.getInstance(utcTimeZone);

....//set the calendar values here.
//i'll just give you an example with a loop, you'll have to customize.
java.sql.Timestamp [] array = new java.sql.Timestamp [5];
for(int i=0; i < array.lenght; i++) {
  array[i] = new java.sql.Timestamp(calendar.getTimeInMillis());
}

PreparedStatement pst = connection.prepareStatement(sql);
pst.setArray(1, array);