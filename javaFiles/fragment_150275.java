List<String> dates = new ArrayList<String>();
if (c.moveToFirst()) {
    do {
        // Stuff that happens for EACH record
        long l = c.getLong(3);
        cal.setTimeInMillis(l);
        String date = formater.format(cal.getTime());

        // .. and actually save the data for use later
        dates.add(date)
    } while (c.moveToNext());
}

// To make the text pretty (e.g. without surrounding braces),
// search for "java list join" or otherwise consume the List in the UI
// in a meaningful fashion.
revDate.setText("" + dates);