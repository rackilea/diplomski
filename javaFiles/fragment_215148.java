//-ORBInitialPort 1050 -ORBInitialHost localhost
                Properties p = new Properties();
                p.put("org.omg.PortableInterceptor.ORBInitializerClass.orb.InterceptorORBInitializer", "");
                //ORB orb = ORB.init(args, p);

                String[] orbArgs = { "-ORBInitialHost", "localhost", "-ORBInitialPort", "1050" };
                //NO_NEED ORB orb = ORB.init( orbArgs, null );
                orb = ORB.init(orbArgs, p);
                //objRef = orb.resolve_initial_references( "NameService" );
                //ncRef = NamingContextExtHelper.narrow( objRef );

                //DII Additional configs
                org.omg.CORBA.Object ncRef = orb.resolve_initial_references ("NameService"); 
                NamingContext nc = NamingContextHelper.narrow (ncRef); 
                NameComponent nComp = new NameComponent ("ABC", ""); 
                NameComponent [] path = {nComp}; 
                objRef = nc.resolve (path);