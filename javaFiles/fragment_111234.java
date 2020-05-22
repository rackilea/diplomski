DatePickerSettings datePickerSettings = new DatePickerSettings();
datePickerSettings.setFormatForDatesBeforeCommonEra("dd.MM.yyyy");
datePickerSettings.setFormatForDatesCommonEra("dd.MM.yyyy");
TimePickerSettings timePickerSettings = new TimePickerSettings();
timePickerSettings.use24HourClockFormat();

DatePicker datePicker = new DatePicker(datePickerSettings);
panel.add(datePicker);
datePicker.setDateToToday();