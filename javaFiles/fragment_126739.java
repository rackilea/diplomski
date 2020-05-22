eSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                **final TextView eSpinnerTV = (TextView) adapterView.getChildAt(position)**

                switch (i) {
                    case 0:
                        final Calendar c = Calendar.getInstance();
                        mHourEnd = c.get(Calendar.HOUR_OF_DAY);
                        mMinuteEnd = c.get(Calendar.MINUTE);

                        TimePickerDialog timePickerDialog = new TimePickerDialog(activityName.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {

                                        Calendar date = Calendar.getInstance();
                                        date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                        date.set(Calendar.MINUTE, minute);
                                        date.set(Calendar.AM_PM, date.get(Calendar.AM_PM));

                                        sEnd(hourOfDay, minute);

                                        uTimeInSF = new SimpleDateFormat("HH:mm:ss").format(date.getTime());

                                        eString = new SimpleDateFormat("hh:mm a").format(date.getTime());

                                        // error on the line below
                                        eSpinnerTV.setText(uTimeAMPM);

                                    }
                                }, mHourEnd, mMinuteEnd, false);
                        timePickerDialog.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });