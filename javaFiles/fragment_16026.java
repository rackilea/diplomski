@Override
public void run(ExampleConfiguration config,
                Environment environment) {

    final Client client = new JerseyClientBuilder(environment).using(config.getJerseyClientConfiguration())
                                                              .build(getName());
    environment.jersey().register(new ExternalServiceResource(client));
}