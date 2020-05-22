final Client config1Client = new JerseyClientBuilder(environment)
        .using(configuration.getJerseyClientConfiguration()).build("config1Client");


    final Client config2Client = new JerseyClientBuilder(environment)
        .using(configuration.getJerseyClientConfiguration()).build("config2Client");