SimpleDateFormat genericDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));

Date start = genericDateFormat.parse("2013-01-03T00:00:00+0400");
Date end = genericDateFormat.parse("2013-01-03T23:59:59+0400");

String range = "[" + dateFormatUTC.format(start) + " TO " + dateFormatUTC.format(end) + "]";