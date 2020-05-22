OnDateChangedListener listener = new OnDateChangedListener() {
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // Show your Toast by calling show()!
        Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();
    }
};
DatePicker dp = (DatePicker)findViewById(R.id.date);

// Use Calendar to set the date to now
Calendar calendar = Calendar.getInstance();
dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), listener);