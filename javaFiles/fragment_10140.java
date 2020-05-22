String dateTimeString = "2017-07-04 12:00:00";
    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString,
            DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"));
    String formattedDate 
            = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    System.out.println(formattedDate);
    String formattedTime 
            = dateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    System.out.println(formattedTime);