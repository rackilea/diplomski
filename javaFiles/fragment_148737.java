// note that I modified the format string slightly
 SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss'Z'");
 // set the timezone to the original date string's timezone
 fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
 Date date = fmt.parse("1998/12/21T13:29:31Z", new ParsePosition(0));

 // then reset to the target date string's (local) timezone
 fmt.setTimeZone(TimeZone.getDefault());
 String localTime = fmt.format(date);