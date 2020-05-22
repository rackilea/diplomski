formatter.setTimeZone(TimeZone.getTimeZone("Europe/London"));
Date date = formatter.parse("2013-04-13 00:00:00.000");

System.out.println("London: " + formatter.format(date));                    
formatter.setTimeZone(TimeZone.getTimeZone("Europe/Stockholm"));
System.out.println("Stockolm: " + formatter.format(date));
formatter.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
System.out.println("Helsinki: " + formatter.format(date));