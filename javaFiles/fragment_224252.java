Calendar calendar = Calendar.getInstance();
calendar.setTime(yourDateObject);
int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
if(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
    //remove this Date
}