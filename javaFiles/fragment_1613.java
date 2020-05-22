ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
            .setOAuthConsumerKey(consumerKey)
            .setOAuthConsumerSecret(consumerSecret)
            .setOAuthAccessToken(accessToken)
            .setOAuthAccessTokenSecret(accessSecret)

            // PROXY
            .setHttpProxyHost(proxyHost)
            .setHttpProxyPort(proxyPort)
            ;