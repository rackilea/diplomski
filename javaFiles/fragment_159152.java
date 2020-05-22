@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // other endpoints
                .exceptionTranslator(e -> {
                    if (e instanceof InternalAuthenticationServiceException) {
                        InternalAuthenticationServiceException internalAuthenticationServiceException = (InternalAuthenticationServiceException) e;

                        // return a ResponseEntity or throw a custom Exception.
                    } 
                });
    }