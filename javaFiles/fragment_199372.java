@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_date);

    Spinner spinnerDateIn = (Spinner) findViewById(R.id.spinnerDateIn);
    final Spinner spinnerDateOut = (Spinner) findViewById(R.id.spinnerDateOut);

    mSpinnerDateInAdapter = new CalendarSpinnerAdapter(SpinnerDateActivity.this, Calendar.getInstance(), 30);
    spinnerDateIn.setAdapter(mSpinnerDateInAdapter);

    spinnerDateIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Calendar dateIn = Calendar.getInstance();
            dateIn.setTimeInMillis(mSpinnerDateInAdapter.getItem(position).getTimeInMillis());
            dateIn.add(Calendar.DAY_OF_YEAR, 1); // add one day
            mSpinnerDateOutAdapter = new CalendarSpinnerAdapter(SpinnerDateActivity.this, dateIn, 30);
            spinnerDateOut.setAdapter(mSpinnerDateOutAdapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}