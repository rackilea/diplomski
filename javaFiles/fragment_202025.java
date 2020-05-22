public class ResponseApi {
    // Your current code

    public Service getEmbedded() { // Not used, only shown as info
        return embedded;
    }

    public List<ServiceData> getEmbeddedServices() {
        return embedded.getServices();
    }
}