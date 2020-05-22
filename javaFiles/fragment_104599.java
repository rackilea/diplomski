DateTimeFormatter desiredFormatter 
            = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSS");
    String truncatedDateTimeString = "2017-06-05T19:27";
    LocalDateTime dateTime = LocalDateTime.parse(truncatedDateTimeString);
    String fixedDateTimeString = dateTime.format(desiredFormatter);
    System.out.println(fixedDateTimeString);