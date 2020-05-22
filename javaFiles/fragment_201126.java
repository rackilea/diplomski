public static int yearsSince(Date pastDate) {
    Calendar present = Calendar.getInstance();
    Calendar past = Calendar.getInstance();
    past.setTime(pastDate);

    int years = 0;

    while (past.before(present)) {
        past.add(Calendar.YEAR, 1);
        if (past.before(present)) {
            years++;
        }
    } return years;
}