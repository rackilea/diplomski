StrongOkHttpClientBuilder.
            forMaxSecurity(activity).
            //withTrustManagers(new TrustManager[] { new MyTrustManager() }).
            withTorValidation().
            withBestProxy().
            build(StrongBuild.this);