doa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        clickedEditText = (EditText) view;
        new DatePickerDialog(FamilyEditActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
});
spoucedob.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        clickedEditText = (EditText) view;
        new DatePickerDialog(FamilyEditActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
});