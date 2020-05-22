Calendar calendar = Calendar.getInstance();
if (month == calendar.get(Calendar.MONTH) && 
    dayOfMonth == calendar.get(Calendar.DAY_OF_MONTH)) {
    //day is today
} else {
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    if (month + 1 == calendar.get(Calendar.MONTH) && dayOfMonth == 1 ||
        month == calendar.get(Calendar.MONTH) && dayOfMonth + 1 == calendar.get(Calendar.DAY_OF_MONTH)) {
        //day is tomorrow
    }
}