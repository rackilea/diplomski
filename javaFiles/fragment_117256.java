final CallbackMatcher.Callback callback = new CallbackMatcher.Callback() {
    public String foundMatch(MatchResult matchResult)
    {
        return "<img src=\"thumbs/" + matchResults.group(1) + "\"/>";
    }
};

final CallbackMatcher callbackMatcher = new CallbackMatcher("/\[thumb(\d+)\]/");
callbackMatcher.replaceMatches(articleText, callback);