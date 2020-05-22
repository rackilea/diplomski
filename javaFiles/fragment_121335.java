compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {    
            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                setNewTitleBar(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }

    private void setNewTitleBar(String newTitle) {
        getSupportActionBar().setTitle(newTitle);
    }
}