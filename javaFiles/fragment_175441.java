LocalDateTime end = tend.getLocalDateTime();

// if you need these:
LocalDate endDate = end.toLocalDate();
LocalTime endTime = end.toLocalTime();

// to display:
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
String stringEnd = formatter.format(end);