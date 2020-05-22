formatter = new SimpleDateFormat("MM/dd/yy");
String s = formatter.format(date);
// 01/09/02

formatter = new SimpleDateFormat("dd-MMM-yy");
s = formatter.format(date);
// 29-Jan-02

// Examples with date and time; see also
// Formatting the Time Using a Custom Format
formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
s = formatter.format(date);
// 2002.01.29.08.36.33

formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
s = formatter.format(date);
// Tue, 09 Jan 2002 22:14:02 -0500