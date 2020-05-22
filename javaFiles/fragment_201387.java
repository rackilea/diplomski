MonthDay md = MonthDay.of(m, d);
MonthDay start = MonthDay.of(3, 20);
MonthDay end = MonthDay.of(6, 20);
if (md.isAfter(start) && md.isBefore(end)) {
    System.out.println(true);
} else {
    System.out.println(false);
}