OnDateChangedListener periodListener = null;
OnDateChangedListener birthdayListener  = null;

periodListener = new OnDateChangedListener() {
         @Override
         public void onDateChanged(DatePicker periodDatePicker, int newYear, int newMonth, int newDay) {
              Number = 1;
              birthDayDatePicker.init(currentYear, currentMonth, currentDay, null);
              birthDateCalculations();
              birthDayDatePicker.init(currentYear, currentMonth, currentDay, birthdayListener);
         }


birthdayListener = new OnDateChangedListener () {    
         @Override
         public void onDateChanged(DatePicker birthDayDatePicker, int newYear, int newMonth, int newDay) {
              Number = 2;
              periodDatePicker.init(currentYear, currentMonth, currentDay, null);
              periodDateCalculations();               
              periodDatePicker.init(currentYear, currentMonth, currentDay, periodListener);
         }
    });


birthDayDatePicker.init(currentYear, currentMonth, currentDay, birthdayListener);
periodDatePicker.init(currentYear, currentMonth, currentDay, periodListener);