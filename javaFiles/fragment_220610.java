//your input
     String date = "Tue Apr 16 10:59:11 EDT 2019";
     //create new formatter for parsing your input
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
     //create new zonedDateTime from parsing an input with provided formatter
     ZonedDateTime zonedDateTime = ZonedDateTime.parse(date,formatter);