final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
ZonedDateTime endDateTime = StringDateUtils.getZonedDateMinute(latestKey);
ZonedDateTime dateTime = StringDateUtils.getZonedDateMinute(earliestKey);
for (; ! dateTime.isAfter(endDateTime); dateTime = dateTime.plusMinutes(10)) {
    System.out.println(dateTime.format(formatter));
}