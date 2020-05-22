String oldDate="2014-06-07";
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date date=dateFormat.parse(oldDate);
System.out.println(date);

String newDate=dateFormat.format(date);
System.out.println(newDate);