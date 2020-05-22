Calendar mCalendarFirst = Calendar.getInstance();
mSelectedCalendar.set(Calendar.YEAR, your_year_from_frist_datepicker);
mSelectedCalendar.set(Calendar.MONTH, your_month_from_frist_datepicker);
mSelectedCalendar.set(Calendar.DAY_OF_MONTH, your_day_from_frist_datepicker);

Calendar mCalendarSecond = Calendar.getInstance();
mSelectedCalendar.set(Calendar.YEAR, your_year_from_second_datepicker);
mSelectedCalendar.set(Calendar.MONTH, your_month_from_seconf_datepicker);
mSelectedCalendar.set(Calendar.DAY_OF_MONTH, your_day_from_second_datepicker);

if(mCalendarSecond.getTimeInMillis() <= mCalendarFirst.getTimeInMillis())
{
        //Your second date is less than first date
        //Show your dialog here.
}