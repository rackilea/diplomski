LocalDateTime dateTime = new LocalDateTime(2015, 3, 28, 14, 0, 0); 
    DateTime srcDateTime = dateTime.toDateTime(DateTimeZone.forID("Asia/Colombo"));
    DateTime dstDateTime = srcDateTime.withZone(DateTimeZone.forID("America/New_York"));
    Date madridTime =dstDateTime.toLocalDateTime().toDateTime().toDate();


    System.out.println("Asia/Colombo -> "+srcDateTime.toDateTime());
    System.out.println("America/New_York -> "+madridTime);