//Set up Proxy user credentials
    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(
            new AuthScope(PROXY_ADDRESS, PROXY_PORT), 
            new UsernamePasswordCredentials(PROXY_USER, PROXY_PASSWORD));

    //Set up Twilio user credentials
    credsProvider.setCredentials(
            new AuthScope("api.twilio.com", 443), 
            new UsernamePasswordCredentials(ACCOUNT_SID, AUTH_TOKEN));