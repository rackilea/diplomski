public static void main(String[] args) {
    int count = 0;
    LocalDate date1 = LocalDate.of(1901, Month.JANUARY, 1);
    LocalDate endDate = LocalDate.of(2001, Month.JANUARY, 1);
    while (date1.isBefore(endDate)) {
        date1 = date1.plusMonths(1);
        if (date1.getDayOfWeek() == DayOfWeek.SUNDAY) {
            count++;
        }
    }
    System.out.println(count);
}