public class WebService {
    private static final String APPLICATION_JSON = "application/json";
    private NanoHTTPD.IHTTPSession session;

    public WebService(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }


    public NanoHTTPD.Response get() {
        Map<String, String> response = new HashMap<>();
        String value = this.session.getUri();
        response.put("value", value);
        response.put("request_parameters", GsonProvider.getInstance().getGson().toJson(this.session.getParms()));
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.ACCEPTED, APPLICATION_JSON, GsonProvider.getInstance().getGson().toJson(response));
    }
}