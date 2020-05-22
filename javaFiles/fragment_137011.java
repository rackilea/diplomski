LocalDate date = LocalDate.ofEpochDay(time); // days!
if (date.plusDays(7).isBefore(LocalDate.now())) {
    // DO 1
} else {
    // DO 2
}