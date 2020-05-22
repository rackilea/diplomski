public void onDateChanged(DatePicker view, int year, int monthOfYear,
            int dayOfMonth) {
        if (view.getId() == R.id.datePicker1) {
            startDay = dayOfMonth;
            startMonth = monthOfYear + 1;
            startYear = year;
        }
        if (view.getId() == R.id.datePicker2) {
            endDay = dayOfMonth;
            endMonth = monthOfYear + 1;
            endYear = year;
        }

    }