StringTokenizer t = new StringTokenizer("foo boo baz bar", " ");
    while(t.hasMoreTokens())
    {
        String token = t.nextToken();
        // Do something with the token
    }