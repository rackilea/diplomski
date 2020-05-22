StrongOkHttpClientBuilder.
            forMaxSecurity(activity).
            withTrustManagers(new TrustManager[] { new MyTrustManager() }).
            withTorValidation().
            withSocksProxy().
            withHttpProxy().
            build(StrongBuild.this);