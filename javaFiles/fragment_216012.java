RequestConfig requestConfig = RequestConfig.custom()
        .setConnectTimeout(5000)
        .setSocketTimeout(5000)
        .build();
SocketConfig socketConfig = SocketConfig.custom()
        .setSoTimeout(5000)
        .build();
CloseableHttpClient client = HttpClients.custom()
        .setDefaultRequestConfig(requestConfig)
        .setDefaultSocketConfig(socketConfig)
        .build();