public interface Callback {
    void onSucces(JSONObject response);
    void onError(VolleyError error);
    void onFinished();
}

public void startRequest(RequestOperation operation, final Callback callback) {

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, instance_context.getResources().getString(R.string.base_url), null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            callback.onSuccess(response);
            callback.onFinished();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            callback.onError(error);
            callback.onFinished();
        }
    });
    queue.add(request);
}