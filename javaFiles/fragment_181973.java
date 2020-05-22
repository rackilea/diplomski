try {
    Calendar newCalendar = Calendar.getInstance();
    pickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
            MainActivity.this,
            newCalendar .get(Calendar.YEAR),
            newCalendar .get(Calendar.MONTH),
            newCalendar .get(Calendar.DAY_OF_MONTH)
    );

    pickerDialog.setMinDate(newCalendar);
    newCalendar.add(Calendar.DAY_OF_MONTH, 30);
    pickerDialog.setMaxDate(newCalendar);
    pickerDialog.show(getFragmentManager(), "Date Picker Dialog");
} catch (Exception e) {
    e.printStackTrace();
}