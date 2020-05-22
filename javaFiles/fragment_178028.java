String edi = "UNH+..."; // full edifact as string here

// split EDIFACT string into segments
String[] segments = edi.split("(?<!\?)'");

// loop through segments to find one beginning with DTM+
// lets assume its 3rd segment in array
String dtmSegment = segments[2];

// split DTM segment to get its elements
String[] dtmElements = dtmSegment.split("(?<!\?)\+");

// get date, time, period element
String dtmElement = dtmElements[1];

// split dtmElement to get date/time/period components
String[] dtmComponents = dtmElement.split("(?<!\?):");

// get date/time/period component value
String deliveryDate = dtmComponents[1];