public class Grid_NODEServer extends Grid_HUBServer {
    static Integer NODEPORT = 5555;
    static String PROXYCLASS = "org.openqa.grid.selenium.proxy.DefaultRemoteProxy";

    public static void nodeServer() {
        try {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_EXE );
            System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, IE_DRIVER_EXE);


            RegistrationRequest request = new RegistrationRequest();
            request.setRole( GridRole.NODE );
            File JOSNFile = new File(System.getProperty("user.dir")+"/registerNode.json" );
            request.loadFromJSON( JOSNFile.toString() );

            Map<String, Object> configuration = new HashMap<String, Object>();

            URL remoteURL = new URL(String.format("http://%s:%d", HUBIP, HUBPORT) );
            System.out.println("Remote URL : "+remoteURL);
            configuration.put(RegistrationRequest.AUTO_REGISTER, true);
            configuration.put(RegistrationRequest.HUB_HOST, HUBIP);
            configuration.put(RegistrationRequest.HUB_PORT, HUBPORT);
            configuration.put(RegistrationRequest.REMOTE_HOST, remoteURL);

            configuration.put(RegistrationRequest.PORT, NODEPORT);

            configuration.put(RegistrationRequest.PROXY_CLASS, PROXYCLASS);
            configuration.put(RegistrationRequest.MAX_SESSION, 1);
            //configuration.put(RegistrationRequest.CLEAN_UP_CYCLE, 2000);
            //configuration.put(RegistrationRequest.MAX_INSTANCES, 1);

            request.setConfiguration( configuration );
            GridNodeServer node = new SeleniumServer( request.getConfiguration() );

            SelfRegisteringRemote remote = new SelfRegisteringRemote( request );
            remote.setRemoteServer( node );
            remote.startRemoteServer();
            System.out.format("Selenium Grid node is up and ready to register to the hub " +
                    "%s Running as a grid node: %s ", separator,separator);
            remote.startRegistrationProcess();

            System.out.println("Please Enter to stop service.");
            System.in.read();
            System.in.read();

            remote.stopRemoteServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        nodeServer();
    }
}