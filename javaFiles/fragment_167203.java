public class NoUserAgentGetMethod extends GetMethod {

    public NoUserAgentGetMethod(String uri) {
        super(uri);
    }

    @Override
    protected void addUserAgentRequestHeader(
            HttpState state, HttpConnection connection) {
        // do nothing
    }

}