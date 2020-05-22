DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
LocalDate startDate = LocalDate.parse("01/01/2015", dtf);
LocalDate endDate = LocalDate.parse("12/31/2015", dtf);

LocalDate date = startDate;

Period period = Period.parse("P4M");
// or 
//Period period = Period.ofMonths(4);
// or 
//Period period = Period.of(0, 4, 0);

while (date.isBefore(endDate)) {
    LocalDate to = date.plus(period);
    System.out.println(dtf.format(date) + " - " + dtf.format(to.minusDays(1)));
    date = to;
}