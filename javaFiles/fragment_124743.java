import py4j.GatewayServer;

public class myTest {

    public static void main(String[] args) {
        myTest app = new myTest();
        // app is now the gateway.entry_point
        GatewayServer server = new GatewayServer(app);
        server.start();
    }
}