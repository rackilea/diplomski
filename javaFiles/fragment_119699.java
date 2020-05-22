public void onResume() {
    // Example of reattaching to the fragment
    super.onResume();
    CalendarDatePickerDialogFragment calendarDatePickerDialogFragment = (CalendarDatePickerDialogFragment) getSupportFragmentManager()
            .findFragmentByTag(FRAG_TAG_DATE_PICKER);
    if (calendarDatePickerDialogFragment != null) {
        calendarDatePickerDialogFragment.onDayOfMonthSelected(CHOSEN_YEAR,CHOSEN_MONTH,CHOSEN_DAY);
        calendarDatePickerDialogFragment.setOnDateSetListener(this);
    }
}