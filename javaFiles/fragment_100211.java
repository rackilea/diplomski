DatePickerDialog dpd = new DatePickerDialog(TRTimeReminder.this,
  new DatePickerDialog.OnDateSetListener() {
        @Override
        Public void onDateSet(DatePicker view, int year, int month, int day) {
        c.set(year, month, day);
        String date = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
        dateView.setText(date);
        }

        c.get(Calender.YEAR); // I forgot if you need the ; here when using Java
        c.get(Calender.MONTH;
        c.get(Calender.DAY_OF_MONTH);
});