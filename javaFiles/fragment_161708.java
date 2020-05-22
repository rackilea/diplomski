//  HUB Configuration - org.openqa.grid.internal.utils.configuration.GridHubConfiguration
GridHubConfiguration gridHubConfig = new GridHubConfiguration();
gridHubConfig.host = HUBIP;
gridHubConfig.port = HUBPORT;
gridHubConfig.newSessionWaitTimeout = 50000;
File JOSNFile = new File(System.getProperty("user.dir")+"/gridHub.json" );
gridHubConfig.loadFromJSON( JOSNFile.toString() );

Hub hub = new Hub(gridHubConfig);
hub.start();

// NODE Configuration - org.openqa.selenium.remote.server.SeleniumServer
GridNodeConfiguration configuration = new GridNodeConfiguration();

File JOSNFile = new File(System.getProperty("user.dir")+"/registerNode2.json" );
configuration.loadFromJSON( JOSNFile.toString() );
configuration.role = GridRole.NODE.name();

URL remoteURL = new URL(String.format("http://%s:%d", HUBIP, HUBPORT) );
System.out.println("Remote URL : "+remoteURL);
RegistrationRequest request = new RegistrationRequest( configuration );

GridNodeServer node = new SeleniumServer( request.getConfiguration() );

SelfRegisteringRemote remote = new SelfRegisteringRemote( request );
remote.setRemoteServer( node );
remote.startRemoteServer();
remote.startRegistrationProcess();