String rx = "(?i)w(?:e{2})?k(\\d+)(?:(?:\\s*until\\s*|[ _\\/])(?:w(?:e{2})?k)?(\\d+))?"; 
String s = "Soccer International wk43\nNational Geopgraphic (wk50)\nSchoolpaper wk39/wk43\nSome magazine week12 until 16\nAnother magazine wk36_38\nAnother magazine wk36_wk38"; 
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile(rx).matcher(s);
while (m.find()) {
    String replacement = m.group(2) == null ? // Check if Group 2 is matched
            "week " + m.group(1):             // If not, use just Group 1
            "week " + m.group(1) + " - week " + m.group(2); // If yes, Group 2 is added
    m.appendReplacement(result, replacement); //  Add the replacement
}
m.appendTail(result);
System.out.println(result.toString());