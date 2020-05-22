@Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // myCalendar your calendar object
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, month);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }
};