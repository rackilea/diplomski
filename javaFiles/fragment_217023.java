DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser();
DateTime result;
Date newResult;
result = parser.parseDateTime("2014-02-16T00:00:00Z");
newResult = result.toDate();
System.out.println(newResult);