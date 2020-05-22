public long addEventToCalender(ContentResolver cr, String title, String addInfo, String place, int status,
                                      long startDate, boolean isRemind,long endDate) {
    String eventUriStr = "content://com.android.calendar/events";
    ContentValues event = new ContentValues();
    // id, We need to choose from our mobile for primary its 1
    event.put("calendar_id", 1);
    event.put("title", title);
    event.put("description", addInfo);
    event.put("eventLocation", place);
    event.put("eventTimezone", "UTC/GMT +2:00");

    // For next 1hr
    event.put("dtstart", startDate);
    event.put("dtend", endDate);
    //If it is bithday alarm or such kind (which should remind me for whole day) 0 for false, 1 for true
    // values.put("allDay", 1);
    //  event.put("eventStatus", status);
    event.put("hasAlarm", 1);

    Uri eventUri = cr.insert(Uri.parse(eventUriStr), event);
    long eventID = Long.parseLong(eventUri.getLastPathSegment());

    if (isRemind) {
        String reminderUriString = "content://com.android.calendar/reminders";
        ContentValues reminderValues = new ContentValues();
        reminderValues.put("event_id", eventID);
        // Default value of the system. Minutes is a integer
        reminderValues.put("minutes", 5);
        // Alert Methods: Default(0), Alert(1), Email(2), SMS(3)
        reminderValues.put("method", 1);
        cr.insert(Uri.parse(reminderUriString), reminderValues); //Uri reminderUri =
    }
    return eventID;
}