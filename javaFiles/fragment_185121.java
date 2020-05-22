// from an Excel sheet
    String dateString = cellB2.getStringCellValue();
    String timeString = cellB3.getStringCellValue();

    TimeZone tz = TimeZone.getDefault(); 

    // NEW!
    DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, l); 
    dateTimeFormat.setTimeZone(tz);

    Date actualDateTime = dateTimeFormat.parse(dateString + " " + timeString);
    assertFalse(now.after(actualDateTime));