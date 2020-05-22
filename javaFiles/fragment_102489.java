MaterialCalendarView calendarView = new MaterialCalendarView(getActivity());
 calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
     @Override
     public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
            //Do something like this
            Date date1 = date.getDate();
     }
 });