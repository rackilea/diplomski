DateTime serverDate = new DateTime(2014, 10, 6, 6, 12);     // US zone 
DateTime dateInMadrid = serverDate.withZone(spZone); // zone is Madrid, but .getMillis() will return the same value
DateTime startDate = new DateTime(2014, 10, 6, 8, 0); // US zone
// startDate = startDate.withZone(spZone) - this will not change the result
DateTime endDate = new DateTime(2014, 10, 6, 21, 0);  // US zone
// endDate = endDate.withZone(spZone) - this will also not change the result
System.out.println(dateInMadrid .isAfter(startDate) && dateInMadrid .isBefore(endDate)); 
// false - it is correct. because all dates were created in US zone