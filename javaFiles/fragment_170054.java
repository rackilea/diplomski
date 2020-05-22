Calendar calendar = Calendar.getInstance();
int day = calendar.get(Calendar.DAY_OF_WEEK); 

switch (day) {
    case Calendar.SUNDAY:
        // Current day is Sunday
        break;
    case Calendar.MONDAY:
        // Current day is Monday
        break;
    case Calendar.TUESDAY:
        // etc.
        break;
}