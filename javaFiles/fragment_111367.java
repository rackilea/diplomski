System.out.println(input_row.newColumn);
SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
Date date = parserSDF.parse(input_row.newColumn);
String dDate = null; 
parserSDF = new SimpleDateFormat("yyyy-MM-dd");
dDate = parserSDF.format(date);
System.out.println(dDate);