private DatePickerDialog.OnDateSetListener dDateSetListener = new DatePickerDialog.OnDateSetListener() {


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {

        mCalendar.set(year, monthOfYear, dayOfMonth);
        long d = mCalendar.getTimeInMillis();

        saveData(nameText.getText().toString(), d);
        // updateDisplay();
}

private void saveData(String str, long d) {
    SharedPreferences.Editor editor = sf.edit();

    editor.putString("name", str); 
    editor.putLong("dday", d); 

    editor.commit(); 
}