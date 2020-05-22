RequestConfig localConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.STANDARD)
            .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM))
            .build();

httpClient = HttpClients.custom()
            .setDefaultCookieStore(new BasicCookieStore())
            .setDefaultCredentialsProvider(credsProvider)
            .setDefaultRequestConfig(localConfig)
            .build();