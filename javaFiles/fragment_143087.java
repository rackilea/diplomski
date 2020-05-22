Calendar myCalendar;
int mYear, mMonth, mDay;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.upload);
    Button selectUploadButton = (Button) findViewById(R.id.select_image);
    selectUploadButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            DatePickerDialog dialog =
                    new DatePickerDialog(MainActivity1.this, mDateSetListener, mYear, mMonth, mDay);
       dialog.getDatePicker().setMaxDate(System.currentTimeMillis());

            dialog.show();
        }
    });

    myCalendar = Calendar.getInstance();

    mYear = myCalendar.get(Calendar.YEAR);
    mMonth = myCalendar.get(Calendar.MONTH);
    mDay = myCalendar.get(Calendar.DAY_OF_MONTH);
}

DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, month);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }
};