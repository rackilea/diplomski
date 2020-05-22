CloseableHttpClient httpClient = HttpClients.custom()
            //.setConnectionManager(poolingConnectionManager) //this causes TLS errors so I commented it out until this final issue is solved.
            .setRetryHandler(new DefaultHttpRequestRetryHandler(2, true))
            .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
            .setDefaultRequestConfig(requestConfig)
            .setDefaultCredentialsProvider(credsProvider)
            .setDefaultHeaders(headers)
            .useSystemProperties()
            .build();