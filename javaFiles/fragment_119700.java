button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final CalendarDatePickerDialogFragment cdp2 = new CalendarDatePickerDialogFragment()
                    .setOnDateSetListener(CalendarPicker.this);


            cdp2.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);

            //here
            cdp2.onDayOfMonthSelected(CHOSEN_YEAR,CHOSEN_MONTH,CHOSEN_DAY);

            cdp2.setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {

                @Override
                public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                    mResultTextView.setText(getString(R.string.calendar_date_picker_result_values, year, monthOfYear+1, dayOfMonth));
                }
            });
        }
});