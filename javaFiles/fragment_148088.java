String strDate = "06/04/1992";
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
Date date = dateFormat.parse(strDate);

System.out.println(date);

// Output
Thu Jun 04 00:00:00 CDT 1992