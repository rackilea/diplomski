public class LoadServerData {

    public static interface Listener {
        public void onSuccess(JSONArray data);
        public void onError(Exception error);
    }

    public static void getServerData(Listener listener) {
        Call call = DataRetriever.getDataByGet(URLCombiner.GET_FRONT_PAGE_ITEMS);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        JSONObject result = new JSONObject(response.body().string());
                        int errorCode = result.getInt("ErrorCode");
                        if (errorCode == 0) {
                            JSONArray arrayData = result.getJSONObject("Value").getJSONArray("hot");  //the data I would like to return.
                            listener.onSuccess(arrayData);
                        } else {
                            listener.onError(...);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.onError(e);
                    }
                } else {
                    listener.onError(...);
                }
            }
        });
    }
}