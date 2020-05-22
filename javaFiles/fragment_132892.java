final Calendar c = Calendar.getInstance();
int mYear = c.get(Calendar.YEAR);
int mMonth = c.get(Calendar.MONTH);
int mDay = c.get(Calendar.DAY_OF_MONTH);

DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
  @Override
  public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
    // dd.MM.yyyy
    register_textview_birthday.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
  }
}, mYear, mMonth, mDay);
datePickerDialog.show();