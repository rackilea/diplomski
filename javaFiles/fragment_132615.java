public void show() {
        Calendar now = Calendar.getInstance();

        DatePickerDialog dpd = DatePickerDialog.newInstance(
                PostInfo.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.setMinDate(Calendar.getInstance());
        now.add(Calendar.DAY_OF_MONTH, 30);

        dpd.setMaxDate(now);

        dpd.show(getFragmentManager(), "Datepickerdialog");

 }