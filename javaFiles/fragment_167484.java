@Component
@Endpoint(id = "custom-health")
public class CustomHealthEndpoint {

    @ReadOperation
    public String customEndPointByName(@Selector String name) {
        return "custom-end-point : " + name;
    }
    @WriteOperation
    public void writeOperation(@Selector String name) {
        System.out.println("Write Operation! :: " + name);
    }
    @DeleteOperation
    public void deleteOperation(@Selector String name){
        System.out.println("Delete Operation! :: " + name);
    }
}