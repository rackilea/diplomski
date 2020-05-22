@Override
public void loadBus(ServletConfig servletConfig) throws ServletException {
        super.loadBus(servletConfig);        

        // You could add the endpoint publish codes here
        Bus bus = cxf.getBus();
        BusFactory.setDefaultBus(bus); 
        Endpoint.publish("/Greeter", new GreeterImpl());

        // You can als use the simple frontend API to do this
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setBus(bus);
        factory.setServiceClass(GreeterImpl.class);
        factory.setAddress("/Greeter");
        factory.create();              
    }