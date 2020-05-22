call.enqueue(new Callback() {
    @Override
    public void onFailure(Call call, IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        try {

            String jsonData = response.body().string();
            String jsonHead = response.headers("Set-Cookie").toString();
            Log.v(TAG, jsonData);

            if (response.isSuccessful()) {
                mData = parseDataFeed(jsonData);
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ListFeedAdapter adapter = new ListFeedAdapter(mData.getDataFeeds());
                        rexyxlerView.setAdapter(adapter);
                        updateDisplay();
                    }
                });

            }
        }
        catch (IOException e) {
            Log.e(TAG, "Exception caught: ", e);
        }
        catch (JSONException e) {
            Log.e(TAG, "Exception caught: ", e);
        }
    }
});