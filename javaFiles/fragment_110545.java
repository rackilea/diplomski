calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                 Log.e("Event",((MyEventDay) eventDay).getNote()+" <--");
            }
        });