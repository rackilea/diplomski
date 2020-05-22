public <T> void getList(String url, HashMap<String, String> paramsMap, final GetListCallback<T> callback) {
    RequestParams params = convertParams(paramsMap);
    client.get(url, params, new TextHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, String responseBody) {
            try {
                Class cl = getTypeClassOfInterfaceObject(callback);
                List<T> list  = gson.fromJson(responseBody, new ListWithElements<T>(cl));
                if (list != null) {
                    callback.onSuccess(list);
                } else {
                    callback.onFailure();
                }
            } catch (Exception e) {
                e.printStackTrace();
                callback.onFailure();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, String responseBody, Throwable error) {
            error.printStackTrace();
            callback.onFailure();
        }
    });
}

public interface GetListCallback<T> {
    void onSuccess(List<T> list);
    void onFailure();
}