public CalendarSpinnerAdapter(Context context, Calendar startDate, int dayCount) {
    mInflater = LayoutInflater.from(context);
    mDayCount = dayCount;
    mCalendar = Calendar.getInstance();
    mCalendar.setTimeInMillis(startDate.getTimeInMillis());
}