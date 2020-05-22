String testDate = "2019-09-17T23:38:47.342";
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
java.util.Date date = format.parse(testDate);
LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
System.out.println(localDateTime);
System.out.println(localDateTime.getNano());