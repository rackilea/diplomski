JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
sf.setResourceClasses(OurJaxResource.class);

List<Object> providers = new ArrayList<Object>();
sf.setProviders(providers);
sf.setResourceProvider(OurJaxResource.class, new SingletonResourceProvider(new OurJaxResource(), true));
sf.setAddress(ENDPOINT_ADDRESS);

server = sf.create();