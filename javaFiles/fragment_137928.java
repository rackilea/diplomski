public static String replaceMatching(String input, String lowerBound, String upperBound{
    Pattern p = Pattern.compile(".*?"+lowerBound+"(.*?)"+upperBound+".*?");
    Matcher m = p.matcher(input);
    String textToRemove = "";

    while(m.find()){
        textToRemove = m.group(1);
    }
    return input.replace(textToRemove, "");
}