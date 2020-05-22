public class SimpleCallback implements Callback {
    public void onSucces(JSONObject response) {
        doSomethingWithResponse(response);
    }

    public void onError(VolleyError error) {
        doSomethingWithError(error);
    }

    void onFinished() {
        logFinishTime();
    }
}

startRequest(operation, new SimpleCallback());