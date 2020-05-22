DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

Date date = utcFormat.parse("2012-08-15T22:56:02.038Z");

DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
pstFormat.setTimeZone(TimeZone.getTimeZone("PST"));

System.out.println(pstFormat.format(date));