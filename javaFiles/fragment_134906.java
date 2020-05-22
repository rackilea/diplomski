DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
LocalDateTime _120daysLater = LocalDateTime.parse("2016-10-17T12:42:04.000", formatter).minusDays(120);

// This just uses default formatting logic in toString. Don't rely on it if you want a specific format.
System.out.println(_120daysLater.toString());

// Use a format to use an explicitly defined output format
System.out.println(_120daysLater.format(formatter));