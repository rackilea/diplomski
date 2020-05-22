private static InitialContext getWLSContext(String url) throws NamingException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, WLS_CONTEXT_FACTORY);
        //env.put(Context.PROVIDER_URL, "t3://" + host + ":" + port);
        env.put(Context.PROVIDER_URL, url);

        return new InitialContext(env);
    }