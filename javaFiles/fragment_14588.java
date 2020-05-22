Tomcat mTomcat = new Tomcat();
    Connector sslConnector = getSSLConnector(); 
    mTomcat.getService().addConnector(sslConnector);    
    Connector defaultConnector = new Connector();
    defaultConnector.setPort(0);
    mTomcat.getService().addConnector(defaultConnector);

    // Do the rest of the Tomcat setup

    AtomicInteger sslPort = new AtomicInteger();
    sslConnector.addLifecycleListener(event->{
        if( "after_init".equals(event.getType()) )
            sslPort.set(sslConnector.getLocalPort());
    });
    defaultConnector.addLifecycleListener(event->{
        if( "before_init".equals(event.getType()) )
            defaultConnector.setRedirectPort(sslPort.get());
    });

    mTomcat.start();