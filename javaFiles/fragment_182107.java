String regex = "https://www\\.google\\.com/search\\?q=([^&]+).*";
    String   url = "https://www.google.com/search?q=regex+java&ie=utf-8&oe=utf-8&aq=t&rls=org.mozilla:en-US:official&client=firefox-a";
    Pattern pattern = Pattern.compile (regex);
    Matcher matcher = pattern.matcher (url);

    if (matcher.matches ())
    {
        int n = matcher.groupCount ();
        for (int i = 0; i <= n; ++i)
            System.out.println (matcher.group (i));
    }