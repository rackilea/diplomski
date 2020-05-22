final List<Summary> summaries = new ArrayList<Summary>();

// loop through the days
for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
    if (isHoliday(i, month, year, date_value)) {
        String date = i + "-" + month + "-" + year;
        // loop through the events of the day
        for (Event event : events.eventDetails(month, day)) {
            // add a summary for the current day and the current event of the day
            summaries.add(new Summary(date, event.eventdetails));
        } 
    }
}