String patternString = "(?:BLDG\\s)(\\w*)(?:\\s\\S)?";

Pattern pattern = Pattern.compile(patternString);
Matcher matcher = patter.matcher(address);

if(matcher.find())
    String substring = matcher.group(1);