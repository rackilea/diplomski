@MessageEndpoint
public class MyErrorHandler {
    @ServiceActivator(inputChannel = "errorChannel")
    public String handle(String messsage) {
       // do whatever you like
    }
}