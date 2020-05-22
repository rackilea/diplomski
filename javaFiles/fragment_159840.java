RequestConfig requestConfig = RequestConfig.custom()
            .setExpectContinueEnabled(***false***)
            .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
            .setProxyPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC))
            .build();

    return HttpClients.custom()
            .setConnectionManager(connManager)
            .setDefaultCredentialsProvider(creds)
            .setDefaultRequestConfig(requestConfig)
            .build();