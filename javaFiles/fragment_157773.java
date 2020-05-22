int i = 1;
while (start.before(end)) {
    System.out.print(printCalendar(start));
    if (i % 7 == 0) {   // last day of the week
        System.out.println();
        i  = 1;
    } else {
        System.out.print(" - ");
        i++;
    }
    start.add(DATE, 1);
}