public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(String...args) throws Exception {
        new ExampleApplication().run(args);
    }


    public void run(ExampleConfiguration config, Environment env) throws Exception {
        env.jersey().property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        env.jersey().register(new ExampleResource(config.getName()));

        env.jersey().register(RolesAllowedDynamicFeature.class);
        env.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<ExamplePrincipal>()
                        .setAuthenticator(new ExampleAuthenticator())
                        .setAuthorizer(new ExampleAuthorizer())
                        .setRealm("ExampleRealm")
                        .buildAuthFilter()
        ));
        env.jersey().register(new AuthValueFactoryProvider.Binder<ExamplePrincipal>(ExamplePrincipal.class));
    }
}