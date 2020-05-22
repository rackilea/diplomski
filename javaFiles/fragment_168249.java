// In Eclipse
public class ServiceImplementation implements Service {
    public Response getService(String serviceId) {
        return null;
    }
}

// In IntelliJ
public class ServiceImplementation implements Service {
    // Note the @PathParam
    public Response getService(@PathParam("serviceId") String serviceId) {
        return null;
    }
}