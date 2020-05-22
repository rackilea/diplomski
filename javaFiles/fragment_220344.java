String s = "Sun Jan 08 18:38:54 CST 2012";
SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
SimpleDateFormat f1 = new SimpleDateFormat("dd-MM-yy");

Date d = formatter.parse(s);
String d1 = f1.format(d);
//and if you want date object create date from string d1.