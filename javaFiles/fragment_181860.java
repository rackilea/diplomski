private void setListener() {


Calendar calendar = Calendar.getInstance();
datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        StringBuilder  selectedFromDate = new StringBuilder().append(dayOfMonth).append("-").append(monthOfYear + 1).append("-").append(year);
       TextFromDate.setText(selectedFromDate);
       //***Call your server call here. As this method is called when you select a date.***
    }
},


        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
      TextFromDate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();



    }
});
}