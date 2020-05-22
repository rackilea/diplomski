@Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        if(response == null){
            Log.e("TUT", "We did not get a response, not updating the UI.");
        } else {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Log.e("response", jsonObject.toString());
                mListData = parseVideoListFromResponse(jsonObject);
                initList(mListData);
                //adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }