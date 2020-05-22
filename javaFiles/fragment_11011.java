String arrayPatternString = "\\[\\[\"0x\\w+:0x\\w+(.+?[\\d+,\\d+]]])";
Pattern arrayPattern = Pattern.compile(arrayPatternString);
Matcher arrayMatcher = arrayPattern.matcher(responseBody);
while(arrayMatcher.find()) {
    String matched = arrayMatcher.group();
    String g = "(\\-?\\d+(\\.\\d+)?),\\s*(\\-?\\d+(\\.\\d+)?)";
    Pattern gPattern = Pattern.compile(g);
    Matcher gMatcher = gPattern.matcher(matched);
    while(gMatcher.find()) {
        String gMatched = gMatcher.group();
        String[] s = gMatched.split(",");
        Double lat = Double.valueOf(s[0]);
        Double lon = Double.valueOf(s[1]);
        System.out.println("Lat: " + lat);
        System.out.println("Lat: " + lon);
        map.put("latitude", lat);
        map.put("longitude", lon);
    }
}