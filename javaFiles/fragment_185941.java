private TimePickerDialog.OnTimeSetListener mTimeSetListenerStart =
        new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHourStart = hourOfDay;
                mMinuteStart = minute;
                updateDisplayStart();

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                mUserSettings.edit().putLong("starttime", cal.getTimeInMillis()).commit();

            }
        };