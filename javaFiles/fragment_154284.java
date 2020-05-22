@CordaService
public class BootstrapBraidService extends SingletonSerializeAsToken{
    private AppServiceHub appServiceHub;
    private BraidConfig braidConfig;
    public BootstrapBraidService(AppServiceHub appServiceHub){
        this.appServiceHub = appServiceHub;
        this.braidConfig = new BraidConfig()
            // Include a flow on the Braid server.
            .withFlow(ExtendedStatusFlow.IssueFlow.class)
            // Include a service on the Braid server.
            braidConfig.withService(new BraidService(appServiceHub))
            // The port the Braid server listens on.
            braidConfig.withPort(3001)
            // Using http instead of https.
            braidConfig.withHttpServerOptions(new HttpServerOptions().setSsl(false));
        // Start the Braid server.
        braidConfig.bootstrapBraid(this.appServiceHub,null);
    }
}