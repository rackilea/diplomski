public void setBirthDate(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);


        datePickerDialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month += 1;
                String date = null;
                if (month < 10) {
                    if (day < 10) {
                        date = "0" + day + "/" + "0" + month + "/" + year;
                    } else if (day >= 10) {
                        date = day + "/" + "0" + month + "/" + year;
                    }
                } else if (month >= 10) {
                    if (day < 10) {
                        date = "0" + day + "/" + month + "/" + year;
                    } else if (day >= 10) {
                        date = day + "/" + month + "/" + year;
                    }
                }
                Toast.makeText(SimpleActivity.this, date, Toast.LENGTH_SHORT).show();
                textView_birthdate.setText(date);
            }
        };

        DatePickerDialog dialog = new DatePickerDialog( SimpleActivity.this,
                datePickerDialog,
                year, month, day);
        dialog.getWindow();
        dialog.show();
    }