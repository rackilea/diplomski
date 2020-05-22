@Component
public class ServiceComponent {

    @Activate
    void activate(BundleContext c) {
        CompletableFuture.runAsync( ()-> {
            try {
                c.getBundle(0).stop();
            } catch (BundleException e) {
                e.printStackTrace();
            }
        } );        
    }
}