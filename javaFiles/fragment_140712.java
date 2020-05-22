int hours = 0;
int minutes = 0;
private void setTimer () {
    timer = new CounterClass((hours *60 * 60 * 1000) + (minutes * 60 *1000), 1000);
    String hms = String.format("%02d:%02d:00", ), hours, minutes);
    textViewTime.setText(hms);
}
...
noPickerHours.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        hours = newVal;
        setTimer();
    }
});

noPickerMinutes.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        minutes = newVal;
        setTimer();
    }
});