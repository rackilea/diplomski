@Override
            public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
                clients.inMemory()
                        .withClient("resource-serv")
                        .scopes("read")
                        .resourceIds("my-resource")
                        .secret("secret123")
                        .and()
                        .withClient("app")
                        .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                        .scopes("read")
                        .resourceIds("my-resource")
                        .secret("appclientsecret");
            }