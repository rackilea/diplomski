@Bean
public AuthenticationManager authenticationManager() {
        List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
        providers.add(new RealmAuthenticationProvider(new RUPAuthenticator() {
            @Override
            public boolean authenticate(Object username, Object password, Object realm) {
                return (username.equals("sa") && password.equals("sa") && realm.equals("realm2"));
            }
        }));
        return new ProviderManager(providers);
    }