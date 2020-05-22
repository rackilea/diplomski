return HttpClientBuilder.create()
        .disableAutomaticRetries()
        .setSSLSocketFactory(
            new SSLConnectionSocketFactory(
                    new SSLContextBuilder().build(),
                    null,
                    new String[] { "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA" },
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER
            )
        )
        .build();