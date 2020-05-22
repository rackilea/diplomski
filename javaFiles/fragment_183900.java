public class Service {

    @Context 
    UriInfo uriInfo;

    public String getUri() {
        return uriInfo.getRequestUri().toASCIIString();
    }
}