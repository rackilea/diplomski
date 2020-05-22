private static final String FUNCTION_NAME_MATCHER = "([a-zA-Z]\\w*)";
private static final String FUNCTION_MATCHER = "(?s)" + FUNCTION_NAME_MATCHER + "\\([^)]*\\)\\s*\\{[^}]*\\}";

public static List<String> getMatches()
{
    List<String> matchedResults = new ArrayList<>();
    Matcher matcher = Pattern.compile(FUNCTION_MATCHER).matcher(sourceFile);

    while (matcher.find())
    {
        matchedResults.add(matcher.group(1));
    }

    return matchedResults;
}