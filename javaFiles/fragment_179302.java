TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
System.out.println(ZoneId.systemDefault());

TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
System.out.println(ZoneId.systemDefault());

TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
System.out.println(ZoneId.systemDefault());