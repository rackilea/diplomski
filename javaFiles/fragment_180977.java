// This is to parse your current date string
DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String startDate = "2013-09-25";
Date frmDate = sdf.parse(startDate); // Handle the ParseException here

// This is to format the your current date to the desired format
DateFormat sdff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String frmDateStr = sdff.format(frmDate);