final ContentValues event = new ContentValues();
    event.put(Events.CALENDAR_ID, 1);

    event.put(Events.TITLE, title);
    event.put(Events.DESCRIPTION, description);
    event.put(Events.EVENT_LOCATION, location);

    event.put(Events.DTSTART, startTimeMillis);
    event.put(Events.DTEND, endTimeMillis);
    event.put(Events.ALL_DAY, 0);   // 0 for false, 1 for true
    event.put(Events.HAS_ALARM, 1); // 0 for false, 1 for true

    String timeZone = TimeZone.getDefault().getID();
    event.put(Events.EVENT_TIMEZONE, timeZone);

    Uri baseUri;
    if (Build.VERSION.SDK_INT >= 8) {
        baseUri = Uri.parse("content://com.android.calendar/events");
    } else {
        baseUri = Uri.parse("content://calendar/events");
    }

    context.getContentResolver().insert(baseUri, event);