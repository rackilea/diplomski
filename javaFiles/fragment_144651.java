RequestConfig config = RequestConfig.custom()
        .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC, AuthSchemes.DIGEST))
        .build();
CloseableHttpClient httpClient = HttpClients.custom()
        .setDefaultRequestConfig(config)
        .build();