private DatePickerDialog.OnDateSetListener endDateSetListener =
        new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, 
                                  int monthOfYear, int dayOfMonth) {
                        endCal.set(Calendar.YEAR, year);
                        endCal.set(Calendar.MONTH, monthOfYear);
                        endCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDisplay(START_DATE_DIALOG_ID);
            }
        }
;