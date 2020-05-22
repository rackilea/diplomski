WSSecurityEngine secEngine = new WSSecurityEngine();
        WSSConfig wsConfig = WSSConfig.newInstance();
        wsConfig.setProcessor(UsernameToken.TOKEN, new Processor() {

            @Override
            public void handleToken(Element arg0, Crypto arg1, Crypto arg2, CallbackHandler arg3, WSDocInfo arg4, Vector arg5, WSSConfig arg6)
                    throws WSSecurityException {
                // skip the token processing
                logger.debug("Skipping processing of the username token");
            }

            @Override
            public String getId() {
                return null;
            }
        });
        secEngine.setWssConfig(wsConfig);