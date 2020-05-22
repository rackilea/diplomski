private void setAge(View view) {

Calendar calendarB = Calendar.getInstance();
int years = calendarB.get(Calendar.YEAR);
int month = calendarB.get(Calendar.MONTH);
int day = calendarB.get(Calendar.DAY_OF_MONTH);
//int
currentDate = Integer.valueOf(String.valueOf(years) + String.valueOf(month + 1) + String.valueOf(day));

Calendar calendar = Calendar.getInstance();
Calendar dob = Calendar.getInstance();

datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //int
        birthDate = Integer.valueOf(String.valueOf(year) + String.valueOf(monthOfYear + 1) + String.valueOf(dayOfMonth));

        // New code
        dob.set(year, month, day); 
        int age = calendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (calendar.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--; 
        }

        String age = checkDigit(age);
        birth.setText(age);

        datePickerDialog.dismiss();
    }
}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
}