public class ArrayResponseHandler <T extends Entity> extends AsyncHttpResponseHandler {
    private List<T> responses;

    public List<T> getResponses() {
        return this.responses; //return pasing result
    }
}