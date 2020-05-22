private void showDateDailog() {

    final DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {

    @Override
    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDate) {

        year = selectedYear;
        month = selectedMonth;
        day = selectedDate;

        addtime.setText(new StringBuilder().append(year).append("/")
                .append(month + 1).append("/").append(day));

        }
    }, year, month, day);

    final Calendar calendar = Calendar.getInstance();
    Calendar cal = Calendar.getInstance();
    int yy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH);
    int dd = calendar.get(Calendar.DAY_OF_MONTH);
    //Min date setting part
    cal.set(Calendar.MONTH, mm);
    cal.set(Calendar.DAY_OF_MONTH, dd);
    cal.set(Calendar.YEAR, yy);
    datePickerDialog.setMinDate(cal.getTimeInMillis());
    //Maximum date setting part, if you need (Else don't add it)
    /*Calendar calen = Calendar.getInstance();
    calen.set(Calendar.MONTH, mm);
    calen.set(Calendar.DAY_OF_MONTH, dd);
    calen.set(Calendar.YEAR, yy + 2);
    datePickerDialog.setMaxDate(calen.getTimeInMillis());*/
    datePickerDialog.show();
}