@Override
public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
                .withClient("first")
                .secret("secret")
                .scopes("read")
                .authorizedGrantTypes("password")
            .and()
                .withClient("sec")
                .secret("secret")
                .scopes("read")
                .authorizedGrantTypes("password");
}