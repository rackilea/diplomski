NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker1);
String[] numbers = new String[200/5];
for (int i=0; i<numbers.length; i++)
    numbers[i] = Integer.toString(i*5+5);
np.setDisplayedValues(numbers);
np.setMaxValue(numbers.length-1);
np.setMinValue(0);
np.setWrapSelectorWheel(false);

np.setOnValueChangedListener(new OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        int newValue = newVal * 5 + 5;
    }
});