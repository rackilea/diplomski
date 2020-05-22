defaultRequestConfig = RequestConfig.custom()
        .setExpectContinueEnabled(false)
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
        .setProxyPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC))
        .build();

httpclient = HttpClients.custom()
        .setConnectionManager(httpClientConnectionManager)
        .setDefaultCredentialsProvider(credentialsProvider)
        .setDefaultRequestConfig(defaultRequestConfig)
        //.setConnectionTimeToLive(1, TimeUnit.MINUTES)
        .build();