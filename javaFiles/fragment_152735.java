public interface Callback<T> {
    void run(T parameter);
}

public void startRequest(RequestOperation operation, final Callback<JSONObject> onSuccess, final Callback<VolleyError> onError, final Runnable onFinished) {

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, instance_context.getResources().getString(R.string.base_url), null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            onSuccess.run(response);
            onFinished.run();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            onError.run(error);
            onFinished.run();
        }
    });
    queue.add(request);
}