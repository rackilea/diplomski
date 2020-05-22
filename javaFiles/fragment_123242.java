LocalDate now = LocalDate.of(2018, 2, 1);
for(int i = 0; i < 10; i++) {
    now = now.with(next(DayOfWeek.MONDAY));
    int weekNo = ((now.getDayOfMonth()-1) / 7) +1;
    System.out.println("Date : " + now + " == " + weekNo);
}