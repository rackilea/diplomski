LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
    System.out.println(date);
}