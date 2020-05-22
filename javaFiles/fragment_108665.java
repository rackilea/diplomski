private static String replaceNMatches(String input, String regex,
                               String replacement, int numberOfTimes) {

    Matcher m = Pattern.compile(regex).matcher(input);
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(i++ < numberOfTimes && m.find() ){
        m.appendReplacement(sb, replacement); // replaces currently matched part with replacement, 
                                              // and writes replaced version to StringBuilder 
                                              // along with text before the match
    }
    m.appendTail(sb); //lets add to builder text after last match
    return sb.toString();
}