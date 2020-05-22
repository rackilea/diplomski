LocalTime startTime = LocalTime.parse("07:00 PM", DateTimeFormat.forPattern("KK:mm a"));
    LocalTime endTime = LocalTime.parse("10:00 PM", DateTimeFormat.forPattern("KK:mm a"));

    LocalTime selected = new LocalTime(hourOfDay, minute);
    if (selected.isAfter(startTime) && selected.isBefore(endTime)) {
      // do your work
    }