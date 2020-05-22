public String formatString(String input) {
    Pattern pattern = Pattern.compile("\\$\\{\\s*(\\w+\\.\\w+)\\s*\\}");
    Matcher matcher = pattern.matcher(input);
    while(matcher.find()){
        String key = matcher.group(1);
        String value = getValueForProperty(key);// object1.property1,object2.property1
        String output = input.replace(matcher.group(),value);
        input = output;
    }
    return output;
}