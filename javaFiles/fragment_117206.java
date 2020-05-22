private void showDateDiffs() {

    Scanner sc = new Scanner(System.in);
    DateTime dueDate1 = new DateTime()
            .withYear(getInput(sc, "year", "due date 1"))
            .withMonthOfYear(getInput(sc, "month", "due date 1"))
            .withDayOfMonth(getInput(sc, "day", "due date 1"));

    DateTime dueDate2 = new DateTime()
            .withYear(getInput(sc, "year", "due date 2"))
            .withMonthOfYear(getInput(sc, "month", "due date 2"))
            .withDayOfMonth(getInput(sc, "day", "due date 2"));

    final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println(String.format("\nDifference between %s & %s\n",
            df.format(dueDate1.toDate()), df.format(dueDate2.toDate())));
    System.out.println("Years difference "
            + Years.yearsBetween(dueDate2.toLocalDate(),
                    dueDate1.toLocalDate()).getYears());
    System.out.println("Days difference "
            + Days.daysBetween(dueDate2.toLocalDate(),
                    dueDate1.toLocalDate()).getDays());
}

private static int getInput(Scanner sc, String timeUnit,
        String dateIdentifier) {
    System.out.println(String.format("Input %s for %s", timeUnit,
            dateIdentifier));
    return sc.nextInt();
}