class Regex_ComandLine {

public static void main(String[] args) {
    String input = "term1 term2 term3 ((term4 term5)) term6";    //your input
    String[] parsedInput = splitByMatchedGroups(input, "\\w+|\\(\\([\\w\\s]*\\)\\)");

    for (String arg : parsedInput) {
        System.out.println(arg);
    }
}

static String[] splitByMatchedGroups(String string,
                                            String patternString) {
    List<String> matchList = new ArrayList<>();
    Matcher regexMatcher = Pattern.compile(patternString).matcher(string);

    while (regexMatcher.find()) {
        matchList.add(regexMatcher.group());
    }

    return matchList.toArray(new String[0]);
}