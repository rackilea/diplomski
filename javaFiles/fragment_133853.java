private void createHeaders() {

    ...

    final int firstDayOfWeek = mFirstDayOfWeek;
    final int lastDayOfWeek = mLastDayOfWeek;

    ...

    int dayOfWeek = firstDayOfWeek;

    do {

        ...

        // increment dayOfWeek, make sure it's a valid day
        dayOfWeek = dayOfWeek % 7;
        dayOfWeek++;
    } while(dayOfWeek != lastDayOfWeek + 1);

    ...

}