Calendar cal = Calendar.getInstance();
int yy = calendar.get(Calendar.YEAR);
int mm = calendar.get(Calendar.MONTH);
int dd = calendar.get(Calendar.DAY_OF_MONTH);
//Min date setting part
cal.set(Calendar.MONTH, mm);
cal.set(Calendar.DAY_OF_MONTH, dd);
cal.set(Calendar.YEAR, yy);
//Replace your code mDatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()); with the below line
mDatePickerDialog.setMinDate(cal.getTimeInMillis());