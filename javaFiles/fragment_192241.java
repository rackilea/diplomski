String content = "ObjectValue(Name1) ObjectValue(Name2) ObjectValue(Name3)";
String patternString = OBJECT_VALUE+"\\(([^()]+)\\)";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(content);
while(matcher.find()) {
    Log.d("Found item:", matcher.group(1));
}