SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy, h:mm a z", Locale.ENGLISH);

// get current date symbols
String[][] zoneStrings = sdf.getDateFormatSymbols().getZoneStrings();
for (int i = 0; i < zoneStrings.length; i++) {
    // overwrite just America/New_York (my arbitrary choice to be "ET")
    if (zoneStrings[i][0].equals("America/New_York")) {
        zoneStrings[i][2] = "ET"; // short name for standard time
        zoneStrings[i][4] = "ET"; // short name for daylight time
        break;
    }
}
// create another date symbols and set in the formatter
DateFormatSymbols symbols = new DateFormatSymbols(Locale.ENGLISH);
symbols.setZoneStrings(zoneStrings);
sdf.setDateFormatSymbols(symbols);

String dateString = "Aug 15, 2017, 4:58 PM ET";
System.out.println(sdf.parse(dateString));