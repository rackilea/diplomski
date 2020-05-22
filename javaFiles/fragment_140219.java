String s = "2014-01-15T14:23:50.026";
DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSS");

DateTime instant = dtf.parseDateTime(s);
System.out.println(dtf.print(instant)); // 2014-01-15T14:23:50.0260

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS");
Date date = sdf.parse(s);
System.out.println(sdf.format(date)); // 2014-01-15T14:23:50.0026 (bad!)