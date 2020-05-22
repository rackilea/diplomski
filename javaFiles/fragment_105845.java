DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

ZonedDateTime zonedDateTime = ZonedDateTime.parse("Wed Dec 31 16:00:00 EST 1969", dtf);
zonedDateTime = zonedDateTime.plusDays(1);

System.out.println(dtf.format(zonedDateTime));