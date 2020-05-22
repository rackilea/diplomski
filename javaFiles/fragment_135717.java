public class ObjectResponseHandler <T extends Entity> extends AsyncHttpResponseHandler {
    private T response;

    public T getResponse() {
        return this.response; //return pasing result
    }
}