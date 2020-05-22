public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    if (onTimeSetListener != null) {
        Time newTime = new Time();
        newTime.setToNow();
        newTime.hour = hourOfDay;
        newTime.minute = minute;
        onTimeSetListener.onTimeSet(newTime);
    }
}