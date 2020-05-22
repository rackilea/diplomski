public interface Callback<R, E> {
    void onSucces(R response);
    void onError(E error);
    void onFinished();
}

public void startRequest(RequestOperation operation, final Callback<JSONObject, VolleyError> callback) {...}