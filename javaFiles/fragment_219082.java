String inputTime = "9:30 PM";

DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
builder.appendPattern("h:mm a");

LocalTime time = LocalTime.parse(inputTime, builder.toFormatter());