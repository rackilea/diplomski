public class Grid_HUBServer {

    public static String HUBIP = GRIDINFO.HOSTIP.toString();
    public static Integer HUBPORT = 4444;
    static String separator = "\n------------------------\n";

    public static void hubServer() {
        try {
            GridHubConfiguration gridHubConfig = new GridHubConfiguration();
            gridHubConfig.setHost( HUBIP );
            gridHubConfig.setPort( HUBPORT );
            gridHubConfig.setNewSessionWaitTimeout( 50000 );
            File JOSNFile = new File(System.getProperty("user.dir")+"/gridHub.json" );
            gridHubConfig.loadFromJSON( JOSNFile.toString() );


            Hub hub = new Hub(gridHubConfig);
            hub.start();

            System.out.println("Nodes should register to " + hub.getRegistrationURL());
            System.out.format("%s Running as a grid hub: %s\n" +
                    "Console URL : %s/grid/console \n", separator,separator,hub.getUrl());

            System.out.println("Please Enter to stop service.");
            System.in.read();
            System.in.read();

            hub.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        hubServer();
    }
}