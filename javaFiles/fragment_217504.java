private int mDay;
    private int mMonth;
    private int mYear;
    private EditText date;
    private Calendar c = new Calendar();

    ...

    //and in your onCreate method:
    date = (EditText)findViewById(R.id.date_of_birth_as_text);

    date.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
             showDialog(DATE_DIALOG_ID); //DATE_DIALOG_ID is the id of your DatePickerDialog - declared in your layout file

        }
    });

    //default values of the year, month and date - will be changed after click on the EditText view
    mYear = c.get(Calendar.YEAR);
    mMonth = c.get(Calendar.MONTH);
    mDay = c.get(Calendar.DAY_OF_MONTH);

    updateDisplay();

    protected Dialog onCreateDialog(int id) {
        switch(id) {
            case DATE_DIALOG_ID:
            return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay); 
        }
        return null;
     }

    private DatePickerDialog.OnDateSetListener mDateSetListener= new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
            int dayOfMonth) {
            // TODO Auto-generated method stub
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            updateDisplay();
        }
    };

private void updateDisplay() {
    Date currentDate = new Date();
    int age = currentDate.getYear() - mYear;
    date.setText( new StringBuilder().append("The user is ")
            .append(age).append(" years old"));
}