Calendar c = Calendar.getInstance();
int mYear = c.get(Calendar.YEAR);
int mMonth = c.get(Calendar.MONTH);
 int mDay = c.get(Calendar.DAY_OF_MONTH);

 DatePickerDialog dialog =
new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
 dialog.show();