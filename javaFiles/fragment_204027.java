@ApplicationScoped
public class YProducer {

    @Produces
    @RequestScoped  
    public Y create() {
        return null;
    }

    public void destroy(@Disposes Y y) {
        //no-op
    }
}