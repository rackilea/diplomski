Properties props = new Properties();
props.put("com.sun.CORBA.POA.ORBPersistentServerPort", "12345");
ORB orb = ORB.init(args, props);
POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
MyServicePOA myServicePOA = new MyServiceImpl();
rootPOA.activate_object(myServicePOA);
MyService myService = myServicePOA._this(orb);

((com.sun.corba.se.spi.orb.ORB) orb).register_initial_reference("MyService", myService);