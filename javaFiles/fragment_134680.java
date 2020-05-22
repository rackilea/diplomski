// Say you got that from the file
String timeStart = "07:00";
String timeEnd = "17:45";

// Then
LocalTime start = LocalTime.parse(timeStart);
LocalTime stop = LocalTime.parse(timeEnd);
LocalTime now = LocalTime.now();
if (now.isAfter(start) && now.isBefore(stop)) {
    // whatnot
}