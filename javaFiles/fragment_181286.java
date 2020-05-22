Date now = new Date(); // java.util.Date, NOT java.sql.Date or java.sql.Timestamp!
String format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH).format(now);
String format2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH).format(now);
String format3 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);

System.out.println(format1);
System.out.println(format2);
System.out.println(format3);