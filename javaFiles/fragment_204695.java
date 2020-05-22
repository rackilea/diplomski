mDisplayDate.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.setTargetFragment(ExpenseFragment.this, 0);
        datePicker.show(getFragmentManager(), "date picker");
    }
});