String startValue = "01.01.2017 16:30";
String endValue = "04.01.2017 23:30";

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        .appendPattern("dd.MM.yyyy HH:mm")
        .toFormatter(Locale.UK);

LocalDateTime startDate = LocalDateTime.parse(startValue, formatter);
LocalDateTime endTime = LocalDateTime.parse(endValue, formatter);

List<LocalDateTime> times = new ArrayList<>(10);
for (LocalDateTime time = startDate; time.isBefore(endTime); time = time.plusDays(1)) {
    times.add(time.withHour(16).withMinute(30));
    times.add(time.withHour(23).withMinute(00));
}

for (LocalDateTime zdt : times) {
    System.out.println(formatter.format(zdt));
}