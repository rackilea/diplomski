private void timePicker(){
    // Get Current Time
    time = LocalTime.now(ZoneId.systemDefault());
    // Launch Time Picker Dialog
    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
            android.R.style.Theme_Holo_Light_Dialog,
            new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay,int minute) {

                    time = LocalTime.of(hourOfDay, minute);

                    milliseconds = date.atTime(time)
                            .atZone(ZoneId.systemDefault())
                            .toInstant()
                            .toEpochMilli();
                    Log.e("LONGGGGGGG", String.valueOf(milliseconds));
                }
            },
            time.getHour(),
            time.getMinute(),
            true);
    timePickerDialog.show();

}