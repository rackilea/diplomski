numberPicker.setOnValueChangedListener(
    new NumberPicker.OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        numberView.setText("I am " + newVal);

        int color;
        if (newVal < 30) {
            color = Color.parseColor("#ff0000");
        } else if (newVal < 60) {
            color = Color.parseColor("#00ff00");
        } else {
            color = Color.parseColor("#0000ff");
        }
        numberView.setTextColor(color);
    }
});