public class BaseCampApplication extends Application {
    private Restlet root;

    public Restlet createInboundRoot() {
        return root;
    }

    public void setRoot(Restlet root) {
        this.root = root;
    }
}