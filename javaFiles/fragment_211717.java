import javax.annotation.PreDestroy;

@Path("/")
@Singleton
public class MyResource {
    private Map<String, MyObject> cache;

    public MyResource() {
    }

    @PreDestroy
    public void preDestroy() {
        // do cleanup
    }
}