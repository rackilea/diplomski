List<String> days = new LinkedList<>();
for (int i = 0; i < differenceInDays; i++) {
    dayOfWeek++;
    if (7 < dayOfWeek) {
        // if we have reached the last day of the week, we reset to the first day of the week
        dayOfWeek = 1;
    }

    switch (dayOfWeek) {
        case Calendar.SATURDAY:
            days.add("Saturday");
            break;
        // add other cases here
    }
}