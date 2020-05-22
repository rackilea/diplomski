RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.BEST_MATCH)
                .setExpectContinueEnabled(true)
                .setStaleConnectionCheckEnabled(true).setSocketTimeout(timeout)
                .build();

        if (proxyHost != null) {
            defaultRequestConfig = RequestConfig.copy(defaultRequestConfig)
                    .setProxy(new HttpHost(proxyHost, proxyPort)).build();
        }

        method.setConfig(defaultRequestConfig);