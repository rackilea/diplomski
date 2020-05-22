JaxWsClientFactoryBean factory = new JaxWsClientFactoryBean();
factory.setServiceClass(MyServiceInterface.class);
factory.setAddress("myEndpoint");
List<Interceptor<? extends Message>> interceptors = new ArrayList<Interceptor<? extends Message>>();
interceptors.add(new HeaderOutInterceptor());
factory.setOutInterceptors(interceptors);
factory.setBindingId("http://www.w3.org/2003/05/soap/bindings/HTTP/");//soap 1.2
MyServiceInterface service = (MyServiceInterface) factory.create();