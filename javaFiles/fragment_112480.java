long hours = difference.toHours();
long mins = difference.minusHours(hours).toMinutes();

// Or if you're lucky enough to be using Java 9+
//String formatted = String.format("%dhrs %02dmins", duration.toHours(), duration.toMinutesPart());
String formatted = String.format("%dhrs %02dmins", hours, mins);