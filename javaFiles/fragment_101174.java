String timeString = json.substring(json.indexOf("(") + 1, json.indexOf(")"));
String[] timeSegments = timeString.split("\\+");
// May have to handle negative timezones
int timeZoneOffSet = Integer.valueOf(timeSegments[1]) * 36000; // (("0100" / 100) * 3600 * 1000)
int millis = Integer.valueOf(timeSegments[0]);
Date time = new Date(millis + timeZoneOffSet);