long timeplayed = 0;
Pattern endTimePattern = Pattern.compile("\"ms_played\":\\s\"(\\d*)\"");
String line = "\"somedata\", \"ms_played\": \"0815\", \"somedata\"";
Matcher matcher = endTimePattern.matcher(line);
matcher.find();
timeplayed += Long.parseLong(matcher.group(1));
System.out.println(timeplayed); // 815