fromDate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Calendar mcurrentDate = Calendar.getInstance();
        final int mYear = mcurrentDate.get(Calendar.YEAR);
        final int mMonth = mcurrentDate.get(Calendar.MONTH);
        final int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);


    DatePickerDialog mDatePicker = new DatePickerDialog(SearchResultClass.this, R.style.MyDialogTheme,
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                    fromDate.setText(selectedyear + "-" + month + "-" + selectedday);   

               }
            }, mYear, mMonth, mDay);
 }
  mDatePicker.setTitle(getString(R.string.datepicker_title2));
  mDatePicker.show();
});