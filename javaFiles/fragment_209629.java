mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            month = month + 1;
            final String date = dayOfMonth + "/" + month + "/" + year;
            mDisplayDate.setText(date);
        }
    };
    mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if (minute < 10) {
                String time = " " + hourOfDay + ":" + "0" + minute;
                mDisplayDate.append(time);
            } else {
                String time = " " + hourOfDay + ":" + minute;
                mDisplayDate.append(time);

            }
        }
    };