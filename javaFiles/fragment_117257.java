public class CallbackMatcher
{
    public static interface Callback
    {
        public void foundMatch(MatchResult matchResult);
    }

    private final Pattern pattern;

    public CallbackMatcher(String regex)
    {
        this.pattern = Pattern.compile(regex);
    }

    public String findMatches(String string, Callback callback)
    {
        final Matcher matcher = this.pattern.matcher(string);
        while(matcher.find())
        {
            callback.foundMatch(matcher.toMatchResult());
        }
    }
}