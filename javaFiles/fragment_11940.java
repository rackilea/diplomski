Calendar calendar = Calendar.getInstance();

// if you do not wish to use the current time, but a specific one
// calendar.setTimeInMillis(yourTimeInMillis);

switch (calendar.get(Calendar.DAY_OF_WEEK)) {
    case Calendar.MONDAY:
        // monday
        break;
    case Calendar.TUESDAY:
        // tuesday
        break;
    // ...
}