public <T> void getObject(String url, HashMap<String, String> paramsMap, final GetObjectCallback<T> callback) {
    RequestParams params = convertParams(paramsMap);
    client.get(url, params, new TextHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, String responseBody) {
            try {
                Class cl = getTypeClassOfInterfaceObject(callback);
                T object = gson.fromJson(responseBody, new Element<T>(cl));
                if (object != null) {
                    callback.onSuccess(object);
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

private RequestParams convertParams(HashMap<String, String> paramsMap) {
    RequestParams params = new RequestParams();
    if (paramsMap != null) {
        for (String key : paramsMap.keySet()) {
            params.put(key, paramsMap.get(key));
        }
    }
    return params;
}

public interface GetObjectCallback<T> {
    void onSuccess(T item);
    void onFailure();
}