SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));

System.out.println("Current Timezone: " + TimeZone.getDefault());

String dateStrIn = "2016-08-01T08:00:00 WET";
Date date = dateFormat.parse(dateStrIn);
dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
String dateStrOut = dateFormat.format(date);

System.out.println("Input date String: "+dateStrIn);
System.out.println("Date.toString() "+date);
System.out.println("Output date String: "+dateStrOut);