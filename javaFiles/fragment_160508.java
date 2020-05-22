DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/u h:m:s a");
LocalDateTime dateTime = LocalDateTime.parse("29/1/2017 5:40:00 AM", dateTimeFormatter);
LocalDateTime endDateTime = LocalDateTime.parse("29/1/2017 6:00:00 AM", dateTimeFormatter);

for(; !dateTime.isAfter(endDateTime); dateTime = dateTime.plusMinutes(5))
    System.out.println(dateTime.format(dateTimeFormatter));