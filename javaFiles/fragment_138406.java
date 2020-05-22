// assuming the offset "0700" is positive (7 hours ahead UTC)
String dateStr = "2017101800000700";

// insert the "+" manually, so input becomes 201710180000+0700
dateStr = dateStr.substring(0, 12) + "+" + dateStr.substring(12, 16);
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMddHHmmXX");
System.out.println(LocalDateTime.parse(dateStr, fmt)); // 2017-10-18T00:00