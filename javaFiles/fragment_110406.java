birthDayDatePicker = (DatePicker)findViewById(R.id.DatePickerBirthDay);
        periodDatePicker = (DatePicker)findViewById(R.id.DatePickerPeriod);

        //initialize period date picker with current date and on date change listener 
        periodDatePicker.init(currentYear, currentMonth, currentDay, new OnDateChangedListener()
        {

            @Override
            public void onDateChanged(DatePicker periodDatePicker, int currentYear, int currentMonth,int currentDay) {
                // TODO Auto-generated method stub
                Number = 1;
                birthDayDatePicker.init(currentYear, currentMonth, currentDay, null);
                birthDateCalculations();

            }
        });

        //initialize birth date picker with current date and on date change listener 
        birthDayDatePicker.init(currentYear, currentMonth, currentDay, new OnDateChangedListener () {

            @Override
            public void onDateChanged(DatePicker birthDayDatePicker, int currentYear, int currentMonth, int currentDay) {
                // TODO Auto-generated method stub
                Number = 2;
                periodDatePicker.init(currentYear, currentMonth, currentDay, null);
                periodDateCalculations();

                }
        });

}

> Blockquote