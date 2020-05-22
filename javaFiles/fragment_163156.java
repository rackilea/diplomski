ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
factory.setServiceClass(AWSECommerceServicePortType.class);
factory.setAddress("https://soap.amazon.com/onca/soap?Service=AWSECommerceService");
factory.getInInterceptors().add(new LoggingInInterceptor());
factory.getOutInterceptors().add(new LoggingOutInterceptor());
AWSECommerceServicePortType ss = (AWSECommerceServicePortType) factory.create();