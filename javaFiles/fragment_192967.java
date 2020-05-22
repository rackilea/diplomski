int mYear, mMonth, mDay;

final Calendar c = Calendar.getInstance();
mYear = c.get(Calendar.YEAR);
mMonth = c.get(Calendar.MONTH);
mDay = c.get(Calendar.DAY_OF_MONTH);

dateView = (TextView) findViewById(R.id.date_view);
dateView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatePickerDialog dpd = new DatePickerDialog(MyActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        c.set(year, month, day);
                        String date = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
                        dateView.setText(date);

                       mYear = c.get(Calendar.YEAR);
                       mMonth = c.get(Calendar.MONTH);
                       mDay = c.get(Calendar.DAY_OF_MONTH);
                    }
                }, mYear, mMonth, mDay);
            dpd.show();
        }
    });