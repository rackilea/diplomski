LocalDateTime ldt1 = new LocalDateTime(2014, 5, 1, 0, 0, 0);
LocalDateTime ldt2 = new LocalDateTime(2014, 5, 2, 23, 59, 59);

int days = Days.daysBetween(ldt1.toLocalDate(), ldt2.toLocalDate()).getDays();
if (ldt1.toLocalTime().equals(new LocalTime(0, 0))) {
  days++;
}