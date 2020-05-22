public static void main(String[] args) {
    String startStr = "March 2012";
    String endStr = "April 2013";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
    YearMonth start = YearMonth.parse(startStr, formatter);
    YearMonth end = YearMonth.parse(endStr, formatter);

    Period period = Period.between(start.atDay(1), end.atDay(1));

    System.out.println(period.getYears() + " years and " + period.getMonths() + " months.");
    // prints "1 years and 1 months." (you could add check for the pluralization of course ;) )
}