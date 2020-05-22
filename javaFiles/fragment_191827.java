public class CampaignsResource extends ServerResource {
    private String getUri() {
        Reference resourceRef = getRequest().getResourceRef();
        return resourceRef.toString();
    }

    @Post
    public void createCampaign(CustomerSegment segment) {
        // Handle segment
        (...)

        // You can return something if the client expects
        // to have something returned
        // For creation on POST method, returning a 204 status
        // code with a Location header is enough...
        getResponse().setLocationRef(getUri() + addedSegmentId);
    }
}