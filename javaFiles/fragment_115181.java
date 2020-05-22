ClassLoader c = Thread.currentThread().getContextClassLoader();
Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());

brokerService = BrokerFactory.createBroker("xbean:file:etc/config.xml");
brokerService.start();

Thread.currentThread().setContextClassLoader(c);