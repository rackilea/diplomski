HttpClient.create().create().secure(sslContextSpec -> sslContextSpec
    .sslContext(sslContext)
    .handlerConfigurator(sslHandler -> 
        SSLEngine engine = handler.engine();
        //engine.setNeedClientAuth(true);
        SSLParameters params = new SSLParameters();
        List<SNIMatcher> matchers = new LinkedList<>();

        SNIMatcher matcher = new SNIMatcher(0) {
            @Override
            public boolean matches(SNIServerName serverName) {
                return true;
            }
        };

        matchers.add(matcher);
        params.setSNIMatchers(matchers);
        engine.setSSLParameters(params);
);