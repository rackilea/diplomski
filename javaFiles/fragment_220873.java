RestConfiguration restConfiguration = new RestConfiguration();
restConfiguration.setComponent("servlet");
restConfiguration.setBindingMode(RestConfiguration.RestBindingMode.json);
restConfiguration.setHost("localhost");
restConfiguration.setPort(serverPort);

camelContext.setRestConfiguration(restConfiguration);