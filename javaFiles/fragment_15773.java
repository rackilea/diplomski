String day = data.substring(6,8);
String month = data.substring(4,6);
String year = data.substring(0,4);
String newDate = day + month + year;

StringBuilder sb = new StringBuilder(date); //the variable 'date' contains 20190329 or any other date from the database.
sb.insert(2, "-");
sb.insert(5, "-");
sb.insert(8, "-");