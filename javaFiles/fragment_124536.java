Pattern p = Pattern.compile("(\\d+)(\\w+)\\s+(\\w+)\\s+(\\d+)(\\w+)\\s+(\\d+)(\\w+)");

String line = "20E WED 01PM 0E";
Matcher m = p.matcher(line);
if (! m.matches())
    throw new IllegalArgumentException("Bad input: " + line);
int    fDegree   = Integer.parseInt(m.group(1));
String fDegreeEW = m.group(2);
String day       = m.group(3);
int    time      = Integer.parseInt(m.group(4));
String amPm      = m.group(5);
int    sDegree   = Integer.parseInt(m.group(6));
String sDegreeEW = m.group(7);