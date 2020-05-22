public class WallResponse {

    private Response response;

    public WallResponse() { super();{

    public WallResponse(Response response) {super();this.response = response;}

    public Response getResponse() { return this.response;}

    public void setResponse(Response response) { this.response = response;  }

    @Override
    public String toString() { return "WallResponse [response=" + response + "]"; }

}