public class JSONRequest extends Request<T> {
    private final Listener<T> mListener;
    private final JsonUnmarshaller<T> unmarshaller;

    public JSONRequest(int method, String url, Listener<T> listener,
        ErrorListener errorListener, JsonUnmarshaller<T> unmarshaller) {
        super(method, url, errorListener);
        mListener = listener;
        this.unmarshaller = unmarshaller;
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(
                response.data, HttpHeaderParser.parseCharset(response.headers)
            );
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        try {
            return Response.success(
                unmarshaller.parse(new JSONObject(parsed)), 
                HttpHeaderParser.parseCacheHeaders(response)
            );
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
}