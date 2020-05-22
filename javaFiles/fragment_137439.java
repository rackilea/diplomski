pickStartTime = (TimePicker)findViewById(R.id.timePicker1);
pickStartTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        Log.d("Time", "You picked "
                + String.valueOf(view.getCurrentHour()) + ":"
                + String.valueOf(view.getCurrentMinute()));
    }

});