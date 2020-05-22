Pattern p = Pattern.compile("(\\d+) / (\\d+)");
String myRunway = "12 / 1234";
Matcher m = p.matcher(myRunway);
m.find();  // <----- this 'executes' the matcher, and populates the group info
int nrGroups = m.groupCount();
String rwData = m.group(1); //should have 12
String rwLen = m.group(2); //should have 1234