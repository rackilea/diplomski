ProviderImpl implementor = new ProviderImpl();
JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
svrFactory.setAddress("http://localhost:9000/providerexample");
svrFactory.setServiceBean(implementor);
svrFactory.getInInterceptors().add(new LoggingInInterceptor());
svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
svrFactory.create();