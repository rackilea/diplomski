Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(getActivity(), onDateSet,
                year, month, day);

        // calendar.add(Calendar.DATE, Constants.DateAndMonth.CURRENT_DAY);//Current day
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        // Set the Calendar new date as maximum date of date picker
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());

        // Subtract 90 days from Calendar updated date
        calendar.add(Calendar.DATE, -Constants.DateAndMonth.LAST_NINETY_DAY);

        // Set the Calendar new date as minimum date of date picker
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            datePickerDialog.setTitle("");//Prevent Date picker from creating extra Title.!
        }