private void createWeblogicUser(String username) {
try {
    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.SECURITY_PRINCIPAL, "weblogic");
    env.put(Context.SECURITY_CREDENTIALS, "weblogic");

    String hostname = "myserver";
    int port = 7001;
    String protocol = "rmi";
    String url= new String("/jndi/iiop://myserver:7001/weblogic.management.mbeanservers.domainruntime");

    JMXServiceURL serviceURL = new JMXServiceURL(protocol, hostname, port, url);
    JMXConnector connector = JMXConnectorFactory.connect(serviceURL, env);
    MBeanServerConnection connection = connector.getMBeanServerConnection();

    ObjectName userEditor = null;
    ObjectName mBeanTypeService = new ObjectName( "com.bea:Name=MBeanTypeService,Type=weblogic.management.mbeanservers.MBeanTypeService");
    ObjectName rs = new ObjectName("com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean");
    ObjectName domainMBean = (ObjectName) connection.getAttribute(rs, "DomainConfiguration");
    ObjectName securityConfig = (ObjectName) connection.getAttribute(domainMBean, "SecurityConfiguration");
    ObjectName defaultRealm = (ObjectName) connection.getAttribute(securityConfig, "DefaultRealm");
    ObjectName[] authProviders = (ObjectName[]) connection.getAttribute(defaultRealm, "AuthenticationProviders");

    for(ObjectName providerName : authProviders) {
        System.out.println("Auth provider is: " + providerName) ;

        if(userEditor == null) {
            ModelMBeanInfo info = (ModelMBeanInfo) connection.getMBeanInfo(providerName);
            String className = (String) info.getMBeanDescriptor().getFieldValue("interfaceClassName");
            System.out.println("className is: " + className) ;

            if(className != null) {
                String[] mba = (String[]) connection.invoke(mBeanTypeService
                                        , "getSubtypes"
                                        , new Object[] {"weblogic.management.security.authentication.UserEditorMBean"}
                                        , new String[] {"java.lang.String"}
                                    );
                for(String mb : mba) {
                    System.out.println("Model Bean is: " + mb) ;
                    if(className.equals(mb)) {
                        System.out.println("Found a macth for the model bean and class name!") ;
                        userEditor = providerName;
                    }
                }
            }
        }
    }

    if(userEditor == null)
        throw new RuntimeException("Could not retrieve user editor");

    try {
        connection.invoke(userEditor
                    , "createUser"
                    , new Object[] {username, "password123","User created programmatically."}
                    , new String[] {"java.lang.String", "java.lang.String","java.lang.String"}
        );

        System.out.println("User created successfully") ;
    }
    catch(Exception e){
        e.printStackTrace();
    }

    connector.close();

}
catch(Exception ex) {
    ex.printStacktrace();
}