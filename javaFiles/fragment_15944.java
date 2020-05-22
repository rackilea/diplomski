public interface ApiResultCallback<T> {
    void onSuccess(RestApi.Success<T> successResult);
    void onFailure(RestApi.Failure failureResult);
}

public interface GetHappyCowsCallback extends ApiResultCallback<List<HappyCow>> {
}